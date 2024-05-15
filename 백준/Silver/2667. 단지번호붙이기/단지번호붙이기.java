import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] Dx = {-1, 0, 1, 0};
    static int[] Dy = {0, -1, 0, 1};
    static int[][] Map;
    static boolean[][] Visited;
    static ArrayList<Integer> List = new ArrayList<>();
    static int N;

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map = new int[N][N];
        Visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                Map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Visited[i][j] || Map[i][j] == 0) continue;
                bfs(i, j);
            }
        }

        Collections.sort(List);
        System.out.println(List.size());

        for (int i : List) {
            System.out.println(i);
        }

        br.close();
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        Visited[x][y] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + Dx[i];
                int ny = cur.y + Dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (Visited[nx][ny] || Map[nx][ny] == 0) continue;

                Visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }

        List.add(count);
    }
}
