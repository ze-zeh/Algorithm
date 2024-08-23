import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[n + 1];
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (arr[i]) continue;

            for (int j = 1; j <= n / i; j++) {
                if (arr[i * j]) continue;

                arr[i * j] = true;

                if (++count == k) {
                    System.out.println(i * j);
                    return;
                }
            }
        }

        br.close();
    }
}