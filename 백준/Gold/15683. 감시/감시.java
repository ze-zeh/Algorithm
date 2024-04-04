import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static class CCTV {
        int x;
        int y;
        int type;

        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    static int N;
    static int M;

    static int[][] Map;
    static ArrayList<CCTV> List;
    static int[] Dx = {-1, 0, 1, 0};
    static int[] Dy = {0, -1, 0, 1};
    static int Answer;

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List = new ArrayList<>();
        Map = new int[N][M];
        Answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());

                if (Map[i][j] != 0 && Map[i][j] != 5 && Map[i][j] != 6) {
                    List.add(new CCTV(i, j, Map[i][j]));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Map[i][j] == 5) {
                    five(i, j);
                }
            }
        }

        dfs(Map, 0);
        System.out.println(Answer);

        br.close();
    }

    private static void dfs(int[][] map, int depth) {
        if (depth == List.size()) {
            Answer = Math.min(Answer, count(map));
            return;
        }

        int[][] newMap = copyMap(map);
        int type = List.get(depth).type;
        int x = List.get(depth).x;
        int y = List.get(depth).y;

        switch (type) {
            case 1: {
                for (int i = 0; i < 4; i++) {
                    dfs(one(newMap, x, y, i), depth + 1);
                }
                break;
            }
            case 2: {
                for (int i = 0; i < 2; i++) {
                    dfs(two(newMap, x, y, i), depth + 1);
                }
                break;
            }
            case 3: {
                for (int i = 0; i < 4; i++) {
                    dfs(three(newMap, x, y, i), depth + 1);
                }
                break;
            }
            case 4: {
                for (int i = 0; i < 4; i++) {
                    dfs(four(newMap, x, y, i), depth + 1);
                }
                break;
            }
        }
    }

    static private int[][] copyMap(int[][] map) {
        int[][] newMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            newMap[i] = map[i].clone();
        }

        return newMap;
    }

    static private int[][] one(int[][] map, int x, int y, int dir) {
        int[][] newMap = copyMap(map);
        int nx = x + Dx[dir];
        int ny = y + Dy[dir];

        while (nx < N && ny < M && nx >= 0 && ny >= 0) {
            if (newMap[nx][ny] == 6) break;
            if (newMap[nx][ny] != 0) {
                nx += Dx[dir];
                ny += Dy[dir];

                continue;
            }

            newMap[nx][ny] = -1;
            nx += Dx[dir];
            ny += Dy[dir];
        }

        return newMap;
    }

    static private int[][] two(int[][] map, int x, int y, int dir) {
        int[][] newMap = copyMap(map);
        int nx = x + Dx[dir];
        int ny = y + Dy[dir];

        while (nx < N && ny < M && nx >= 0 && ny >= 0) {

            if (newMap[nx][ny] == 6) break;
            if (newMap[nx][ny] != 0) {
                nx += Dx[dir];
                ny += Dy[dir];
                continue;
            }

            newMap[nx][ny] = -1;
            nx += Dx[dir];
            ny += Dy[dir];
        }

        nx = x + Dx[dir + 2];
        ny = y + Dy[dir + 2];

        while (nx < N && ny < M && nx >= 0 && ny >= 0) {
            if (newMap[nx][ny] == 6) break;
            if (newMap[nx][ny] != 0) {
                nx += Dx[dir + 2];
                ny += Dy[dir + 2];
                continue;
            }

            newMap[nx][ny] = -1;
            nx += Dx[dir + 2];
            ny += Dy[dir + 2];
        }

        return newMap;
    }

    static private int[][] three(int[][] map, int x, int y, int dir) {
        int[][] newMap = copyMap(map);
        int nx = x + Dx[dir];
        int ny = y + Dy[dir];

        while (nx < N && ny < M && nx >= 0 && ny >= 0) {
            if (newMap[nx][ny] == 6) break;
            if (newMap[nx][ny] != 0) {
                nx += Dx[dir];
                ny += Dy[dir];

                continue;
            }

            newMap[nx][ny] = -1;
            nx += Dx[dir];
            ny += Dy[dir];
        }

        nx = x + Dx[(dir + 1) % 4];
        ny = y + Dy[(dir + 1) % 4];

        while (nx < N && ny < M && nx >= 0 && ny >= 0) {
            if (newMap[nx][ny] == 6) break;
            if (newMap[nx][ny] != 0) {
                nx += Dx[(dir + 1) % 4];
                ny += Dy[(dir + 1) % 4];

                continue;
            }

            newMap[nx][ny] = -1;
            nx += Dx[(dir + 1) % 4];
            ny += Dy[(dir + 1) % 4];
        }

        return newMap;
    }

    static private int[][] four(int[][] map, int x, int y, int dir) {
        int[][] newMap = copyMap(map);

        for (int i = 0; i < 4; i++) {
            if (i == dir) continue;

            int nx = x + Dx[i];
            int ny = y + Dy[i];

            while (nx < N && ny < M && nx >= 0 && ny >= 0) {
                if (newMap[nx][ny] == 6) break;
                if (newMap[nx][ny] != 0) {
                    nx += Dx[i];
                    ny += Dy[i];

                    continue;
                }

                newMap[nx][ny] = -1;
                nx += Dx[i];
                ny += Dy[i];
            }
        }

        return newMap;
    }

    static private void five(int i, int j) {
        int x = i;
        int y = j;

        while (x < N) {
            if (Map[x][j] == 6) break;
            if (Map[x][j] != 0) {
                x++;
                continue;
            }

            Map[x][j] = -1;
            x++;
        }

        while (y < M) {
            if (Map[i][y] == 6) break;
            if (Map[i][y] != 0) {
                y++;
                continue;
            }

            Map[i][y] = -1;
            y++;
        }

        x = i;
        y = j;

        while (x >= 0) {
            if (Map[x][j] == 6) break;
            if (Map[x][j] != 0) {
                x--;
                continue;
            }

            Map[x][j] = -1;
            x--;
        }

        while (y >= 0) {
            if (Map[i][y] == 6) break;
            if (Map[i][y] != 0) {
                y--;
                continue;
            }

            Map[i][y] = -1;
            y--;
        }
    }

    static int count(int[][] map) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
