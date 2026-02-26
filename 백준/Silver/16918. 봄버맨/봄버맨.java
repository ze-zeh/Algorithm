import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int R, C, N;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = (str.charAt(j) == 'O') ? 3 : -1;
            }
        }

        for (int t = 0; t < N; t++) {
            passTime();

            if (t % 2 == 1) {
                setBomb();
            }

            explodeBomb();
        }

        printMap(map);
        br.close();
    }

    public static void passTime() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j]--;
            }
        }
    }

    public static void setBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] < 0) {
                    map[i][j] = 3;
                }
            }
        }
    }

    public static void explodeBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 0) continue;

                map[i][j] = -1;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (!checkRange(nx, ny) || map[nx][ny] == 0) continue;

                    map[nx][ny] = -1;
                }
            }
        }
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void printMap(int[][] map) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] >= 0 ? 'O' : '.');
            }
            System.out.println();
        }
    }
}
