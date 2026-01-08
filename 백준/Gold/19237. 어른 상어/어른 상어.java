import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, M, k;
    static int[][][] map;
    static int[] sharks;
    static int[][][] dirs;
    static int answer;
    static int remain;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[N][N][3]; // 번호, 냄새 번호, 지속 시간
        sharks = new int[M];
        dirs = new int[M][4][4];
        answer = 0;
        remain = M;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken()) - 1;
                map[i][j][1] = -1;

                if (map[i][j][0] >= 0) {
                    map[i][j][1] = map[i][j][0];
                    map[i][j][2] = k;
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            sharks[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        for (int i = 0; i < M; i++) {

            for (int x = 0; x < 4; x++) {
                st = new StringTokenizer(br.readLine());

                for (int y = 0; y < 4; y++) {
                    dirs[i][x][y] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
        }

        solve();

        br.close();
    }

    static void solve() {
        while (answer++ < 1000) {
            int[][][] beforeMap = cloneMap(map);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (beforeMap[i][j][0] == -1) {
                        continue;
                    }

                    move(beforeMap[i][j][0], i, j);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j][2] = Math.max(map[i][j][2] - 1, 0);

                    if (map[i][j][2] == 0) {
                        map[i][j][1] = -1;
                    }

                    if (map[i][j][0] >= 0) {
                        map[i][j][1] = map[i][j][0];
                        map[i][j][2] = k;
                    }
                }
            }

            if (remain == 1) {
                System.out.println(answer);
                return;
            }
        }

        System.out.println(-1);
    }

    private static void move(int shark, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[dirs[shark][sharks[shark]][i]];
            int ny = y + dy[dirs[shark][sharks[shark]][i]];

            if (!checkRange(nx, ny)) {
                continue;
            }

            if (map[nx][ny][1] == -1) {
                if (map[nx][ny][0] != -1) {
                    remain--;

                    if (map[nx][ny][0] > shark) {
                        map[nx][ny][0] = shark;
                        sharks[shark] = dirs[shark][sharks[shark]][i];
                    }

                    map[x][y][0] = -1;

                    return;
                }

                map[nx][ny][0] = shark;
                map[x][y][0] = -1;
                sharks[shark] = dirs[shark][sharks[shark]][i];
                return;
            }
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[dirs[shark][sharks[shark]][i]];
            int ny = y + dy[dirs[shark][sharks[shark]][i]];

            if (!checkRange(nx, ny)) {
                continue;
            }

            if (map[nx][ny][1] == shark) {
                map[nx][ny][0] = shark;
                map[x][y][0] = -1;
                sharks[shark] = dirs[shark][sharks[shark]][i];
                return;
            }
        }
    }

    private static boolean checkRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static int[][][] cloneMap(int[][][] map) {
        int[][][] newMap = new int[N][N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 3; k++) {
                    newMap[i][j][k] = map[i][j][k];
                }
            }
        }

        return newMap;
    }
}
