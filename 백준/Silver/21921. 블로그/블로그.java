import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] dp = new int[n + 1];
        int[] arr = new int[n];
        int max = 0;
        int count = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i + 1] = dp[i] + arr[i];
        }

        for (int i = 0; i <= n - x; i++) {
            max = Math.max(max, dp[i + x] - dp[i]);
        }

        for (int i = 0; i <= n - x; i++) {
            if (dp[i + x] - dp[i] == max) {
                count++;
            }
        }

        if (max == 0) {
            System.out.print("SAD");
        } else {
            System.out.println(max);
            System.out.print(count);
        }

        br.close();
    }
}
