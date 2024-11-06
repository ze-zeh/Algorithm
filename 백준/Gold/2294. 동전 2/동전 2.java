import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= K; i++) {
            dp[i] = 10001;
        }

        for (int coin : coins) {
            for (int i = coin; i <= K; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        System.out.println(dp[K] == 10001 ? -1 : dp[K]);
    }
}