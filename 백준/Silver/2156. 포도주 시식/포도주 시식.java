import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[1] = arr[1];
            } else if (i == 2) {
                dp[2] = arr[1] + arr[2];
            } else if (i == 3) {
                dp[3] = Math.max(dp[2], Math.max(arr[1] + arr[3], arr[2] + arr[3]));
            } else {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
            }
        }

        System.out.println(dp[n]);

        br.close();
    }
}
