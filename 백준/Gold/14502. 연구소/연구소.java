import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static class Pair {
        int x = 0;
        int y = 0;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N * M - 2; i++) {
            if (map[i / M][i % M] != 0) continue;

            for (int j = i + 1; j < N * M - 1; j++) {
                if (map[j / M][j % M] != 0) continue;

                for (int k = j + 1; k < N * M; k++) {
                    if (map[k / M][k % M] != 0) continue;
                    int[][] newMap = new int[N][M];

                    for (int a = 0; a < N; a++) {
                        System.arraycopy(map[a], 0, newMap[a], 0, M);
                    }

                    newMap[i / M][i % M] = 1;
                    newMap[j / M][j % M] = 1;
                    newMap[k / M][k % M] = 1;

                    result = Math.max(result, bfs(newMap, N, M));
                }
            }
        }

        System.out.println(result);
    }

    public static int bfs(int[][] map, int N, int M) {
        int count = 0;
        boolean[][] visited = new boolean[N][M];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.x < 0 || p.x >= N || p.y < 0 || p.y >= M || visited[p.x][p.y] || map[p.x][p.y] == 1) continue;

            visited[p.x][p.y] = true;
            map[p.x][p.y] = 2;

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                q.add(new Pair(nx, ny));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }

        return count;
    }
}
