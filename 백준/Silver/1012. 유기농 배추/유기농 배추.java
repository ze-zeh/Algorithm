import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int M;
    static int N;
    static int[] Dx = {-1, 0, 1, 0};
    static int[] Dy = {0, -1, 0, 1};
    static int[][] Map;
    static boolean[][] Visited;

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            System.out.println(solve(br));
        }

        br.close();
    }

    private static int solve(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Map = new int[M][N];
        Visited = new boolean[M][N];
        int count = 0;

        for (int j = 0; j < k; j++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Map[x][y] = 1;
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (Map[i][j] == 1 && !Visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        Visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + Dx[i];
                int ny = cur.y + Dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N || Visited[nx][ny] || Map[nx][ny] == 0) continue;
                Visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }
    }
}
