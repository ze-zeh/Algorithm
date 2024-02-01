import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            int[] dp = new int[n + 1];
            int max = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                dp[j] = dp[j - 1] + Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < j; k++) {
                    int dif = dp[j] - dp[k];
                    max = Math.max(max, dif);
                }
            }

            System.out.println(max);
        }

        br.close();
    }
}
