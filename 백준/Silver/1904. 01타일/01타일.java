import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (n == 1) {
            System.out.println(dp[n]);
            return;
        }
        dp[2] = 2;
        if (n == 2) {
            System.out.println(dp[n]);
            return;
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] % 15746 + dp[i - 2] % 15746) % 15746;
        }

        System.out.println(dp[n]);
        br.close();
    }
}