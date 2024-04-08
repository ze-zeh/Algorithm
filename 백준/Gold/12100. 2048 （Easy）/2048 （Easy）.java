import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[][] Map;
    static int Answer;
    static int Left = 0;
    static int Up = 1;
    static int Right = 2;
    static int Down = 3;

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Map = new int[N][N];
        Answer = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 4; i++) {
            move(copyMap(Map), 0, i);
        }

        System.out.println(Answer);

        br.close();
    }

    static private void move(int[][] map, int depth, int dir) {
        if (depth >= 5) {
            Answer = Math.max(Answer, findMax(map));
            return;
        }

        if (dir == Left) {
            left(map);
        } else if (dir == Up) {
            up(map);
        } else if (dir == Right) {
            right(map);
        } else if (dir == Down) {
            down(map);
        }

        for (int i = 0; i < 4; i++) {
            move(copyMap(map), depth + 1, i);
        }
    }

    private static void left(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == 0) continue;

                int idx = j + 1;

                while (idx < N - 1 && map[i][idx] == 0) {
                    idx++;
                }

                if (map[i][j] == map[i][idx]) {
                    map[i][j] *= 2;
                    map[i][idx] = 0;
                }
            }
        }

        int idx;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] != 0) continue;

                idx = j;

                for (int k = j + 1; k < N; k++) {
                    if (map[i][k] != 0) {
                        map[i][idx] = map[i][k];
                        map[i][k] = 0;
                        break;
                    }
                }
            }
        }
    }

    private static void up(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (map[j][i] == 0) continue;

                int idx = j + 1;

                while (idx < N - 1 && map[idx][i] == 0) {
                    idx++;
                }

                if (map[j][i] == map[idx][i]) {
                    map[j][i] *= 2;
                    map[idx][i] = 0;
                }
            }
        }

        int idx;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (map[j][i] != 0) continue;

                idx = j;

                for (int k = j + 1; k < N; k++) {
                    if (map[k][i] != 0) {
                        map[idx][i] = map[k][i];
                        map[k][i] = 0;
                        break;
                    }
                }
            }
        }
    }

    private static void right(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j > 0; j--) {
                if (map[i][j] == 0) continue;

                int idx = j - 1;

                while (idx > 0 && map[i][idx] == 0) {
                    idx--;
                }

                if (map[i][j] == map[i][idx]) {
                    map[i][j] *= 2;
                    map[i][idx] = 0;
                }
            }
        }

        int idx;

        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j > 0; j--) {
                if (map[i][j] != 0) continue;

                idx = j;

                for (int k = j - 1; k >= 0; k--) {
                    if (map[i][k] != 0) {
                        map[i][idx] = map[i][k];
                        map[i][k] = 0;
                        break;
                    }
                }
            }
        }
    }

    private static void down(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j > 0; j--) {
                if (map[j][i] == 0) continue;

                int idx = j - 1;

                while (idx > 0 && map[idx][i] == 0) {
                    idx--;
                }

                if (map[j][i] == map[idx][i]) {
                    map[j][i] *= 2;
                    map[idx][i] = 0;
                }
            }
        }

        int idx;

        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j > 0; j--) {
                if (map[j][i] != 0) continue;

                idx = j;

                for (int k = j - 1; k >= 0; k--) {
                    if (map[k][i] != 0) {
                        map[idx][i] = map[k][i];
                        map[k][i] = 0;
                        break;
                    }
                }
            }
        }
    }

    static private int[][] copyMap(int[][] map) {
        int[][] newMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            newMap[i] = map[i].clone();
        }

        return newMap;
    }

    static private int findMax(int[][] map) {
        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, map[i][j]);
            }
        }

        return max;
    }
}
