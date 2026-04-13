import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        if (dp[n] < k) {
            System.out.println(-1);
            return;
        }

        System.out.println(recursive(n, k));

        br.close();
    }

    public static String recursive(int n, int k) {

        if (n == 1) {
            return "1";
        } else if (n == 2) {
            if (k == 1) {
                return "1+1";
            } else {
                return "2";
            }
        } else if (n == 3) {
            if (k == 1) {
                return "1+1+1";
            } else if (k == 2) {
                return "1+2";
            } else if (k == 3) {
                return "2+1";
            } else {
                return "3";
            }
        }

        if (k <= dp[n - 1]) {
            return "1+" + recursive(n - 1, k);
        } else if (k <= dp[n - 1] + dp[n - 2]) {
            return "2+" + recursive(n - 2, k - dp[n - 1]);
        } else {
            return "3+" + recursive(n - 3, k - dp[n - 1] - dp[n - 2]);
        }
    }
}
