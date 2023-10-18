import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] dp = new long[N + 1];
        long[] count = new long[M];
        long result = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            dp[i] = (dp[i - 1] + Integer.parseInt(st.nextToken())) % M;

            if (dp[i] == 0) result++;

            count[(int) dp[i]]++;
        }

        for (int i = 0; i < M; i++) {
            if (count[i] > 1) {
                result += count[i] * (count[i] - 1) / 2;
            }
        }

        System.out.println(result);
    }
}
