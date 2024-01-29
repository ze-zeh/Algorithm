import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m;
        int[] dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int k = 1; k <= n; k++) {
            dp[k] = dp[k - 1] + Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        for (int k = 1; k <= m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(dp[j] - dp[i - 1]);
        }

        br.close();
    }
}
