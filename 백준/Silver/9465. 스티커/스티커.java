import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[] a = new int[N + 1];
            int[] b = new int[N + 1];
            int[] dp1 = new int[N + 1];
            int[] dp2 = new int[N + 1];

            for (int j = 1; j <= N; j++) {
                a[j] = Integer.parseInt(st1.nextToken());
                b[j] = Integer.parseInt(st2.nextToken());
            }

            dp1[1] = a[1];
            dp2[1] = b[1];

            for (int j = 2; j <= N; j++) {
                dp1[j] = Math.max(dp2[j - 1] + a[j], dp2[j - 2] + a[j]);
                dp2[j] = Math.max(dp1[j - 1] + b[j], dp1[j - 2] + b[j]);
            }

            System.out.println(Math.max(dp1[N], dp2[N]));
        }

        br.close();
    }
}