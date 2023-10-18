import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int count = 0; count < M; count++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if(i > 1) {
                System.out.println(dp[j - 1] - dp[i - 2]);
            } else {
                System.out.println(dp[j - 1]);
            }
        }
    }
}
