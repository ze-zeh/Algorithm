import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp0 = new long[n + 1];
        long[] dp1 = new long[n + 1];

        dp1[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp0[i] = dp0[i - 1] + dp1[i - 1];
            dp1[i] = dp0[i - 1];
        }

        System.out.println(dp0[n] + dp1[n]);

        br.close();
    }
}
