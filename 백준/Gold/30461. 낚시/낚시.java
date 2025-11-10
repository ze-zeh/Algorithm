import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N, M, Q;
    static int[][] Lake;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        Lake = new int[N + 2][M + 2];

        for (int i = 2; i <= N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 2; j <= M + 1; j++) {
                Lake[i][j] = Lake[i - 1][j] + Lake[i - 1][j - 1] - Lake[i - 2][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            bw.append(Lake[w + 1][q + 1] + "\n");
        }

        bw.flush();
        br.close();
    }
}
