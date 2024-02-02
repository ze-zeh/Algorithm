import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    final static int MAX = 1000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        long[] fx = new long[MAX];
        long[] gx = new long[MAX];

        Arrays.fill(fx, 1);

        for (int i = 2; i < MAX; i++) {
            for (int j = 1; i * j < MAX; j++) {
                fx[i * j] += i;
            }
        }

        for (int i = 1; i < MAX; i++) {
            gx[i] = gx[i - 1] + fx[i];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(gx[n]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
