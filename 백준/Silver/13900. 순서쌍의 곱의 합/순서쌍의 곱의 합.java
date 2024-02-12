import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        long answer = 0;

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        for (int i = 1; i <= n; i++) {
            answer += (sum - arr[i]) * arr[i];
        }

        System.out.print(answer / 2);

        br.close();
    }
}
