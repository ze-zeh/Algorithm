import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[31][31];
        dp[0][0] = 1;

        for (int i = 0; i <= 30; i++) {
            for (int j = 0; j <= i; j++) {
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }

                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            System.out.println(dp[N][N]);
        }

        br.close();
    }
}