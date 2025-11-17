import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] Map;
    static int answer;
    static int[][][] blocks = {
            {{0, 1}, {0, 2}, {0, 3}},
            {{1, 0}, {2, 0}, {3, 0}},
            {{0, 1}, {1, 1}, {1, 2}},
            {{1, 0}, {1, -1}, {2, -1}},
            {{0, 1}, {0, 2}, {1, 2}},
            {{1, 0}, {2, 0}, {2, -1}},
            {{0, -1}, {0, -2}, {-1, -2}},
            {{-1, 0}, {-2, 0}, {-2, 1}},
            {{1, 0}, {2, 0}, {1, -1}},
            {{0, 1}, {0, 2}, {1, 1}},
            {{1, 0}, {2, 0}, {1, 1}},
            {{0, 1}, {0, 2}, {-1, 1}},
            {{1, 0}, {0, 1}, {1, 1}},
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = 0;

        while (true) {
            testCase++;
            N = Integer.parseInt(br.readLine().trim());

            if (N == 0) {
                break;
            }

            Map = new int[N][N];
            answer = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    Map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    solve(i, j);
                }
            }

            System.out.println(testCase + ". " + answer);
        }

        br.close();
    }

    private static void solve(int x, int y) {
        for (int[][] block : blocks) {
            int sum = Map[x][y];
            boolean enable = true;

            for (int[] b : block) {
                int nx = x + b[0];
                int ny = y + b[1];

                if (!checkRange(nx, ny)) {
                    enable = false;
                    break;
                }
                sum += Map[nx][ny];
            }

            if (enable) {
                answer = Math.max(answer, sum);
            }
        }
    }

    private static boolean checkRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}