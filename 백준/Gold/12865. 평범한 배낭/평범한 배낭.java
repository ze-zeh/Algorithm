import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static final int VOLUME = 0;
    static final int COST = 1;

    static int N;
    static int K;
    static int[][] stuff;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stuff = new int[N + 1][2];
        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            stuff[i][VOLUME] = Integer.parseInt(st.nextToken());
            stuff[i][COST] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (stuff[i][VOLUME] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stuff[i][VOLUME]] + stuff[i][COST]);
                }
            }
        }

        System.out.println(dp[N][K]);

        br.close();
    }
}
