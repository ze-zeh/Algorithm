import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[N + 1];

        if (N <= 1) {
            System.out.println(N);
            return;
        }

        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 2].add(dp[i - 1]);
        }

        System.out.println(dp[N]);

        br.close();
    }
}