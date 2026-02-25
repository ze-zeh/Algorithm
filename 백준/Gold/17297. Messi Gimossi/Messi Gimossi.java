import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int index = 3;
        dp = new int[41];

        dp[1] = 5;
        dp[2] = 13;

        while (true) {
            dp[index] = dp[index - 1] + 1 + dp[index - 2];

            if (dp[index] >= M) {
                break;
            }

            index++;
        }
        
        recursive(index, M);

        br.close();
    }

    static void recursive(int index, int n) {
        if (index == 1) {
            System.out.println("Messi".charAt(n - 1));
            return;
        } else if (index == 2) {
            if (n == 6) {
                System.out.println("Messi Messi Gimossi");
            } else {
                System.out.println("Messi Gimossi".charAt(n - 1));
            }

            return;
        }

        int mid = dp[index - 1] + 1;

        if (n < mid) {
            recursive(index - 1, n);
        } else if (n > mid) {
            recursive(index - 2, n - dp[index - 1] - 1);
        } else {
            System.out.println("Messi Messi Gimossi");
        }
    }
}
