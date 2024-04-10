import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] dp = new int[b + 1];
        int k = 1;
        int count = 0;

        for (int i = 1; i <= b; i++) {
            if (count == k) {
                count = 0;
                k++;
            }

            dp[i] = dp[i - 1] + k;
            count++;
        }

        System.out.println(dp[b] - dp[a - 1]);
        br.close();
    }
}
