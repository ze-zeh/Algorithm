import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[n + 1];
        int[] arr = new int[n + 1];
        int max;

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= k; i++) {
            dp[1] += arr[i];
        }

        max = dp[1];

        for (int i = 2; i <= n - k + 1; i++) {
            dp[i] = dp[i - 1] + arr[i + k - 1] - arr[i - 1];
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

        br.close();
    }
}
