import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        if (n == 1) {
            System.out.print(dp[n]);
            return;
        }

        dp[2] = arr[1] + arr[2];
        if (n == 2) {
            System.out.print(dp[n]);
            return;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.print(dp[n]);
        br.close();
    }
}
