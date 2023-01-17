import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] box = new int[n][m];
        int[][] vis = new int[n][m];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new Pair<>(i, j));
                }
                if (box[i][j] == 0) {
                    vis[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.getKey() + dx[k];
                int ny = cur.getValue() + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (vis[nx][ny] >= 0) continue;
                vis[nx][ny] = vis[cur.getKey()][cur.getValue()] + 1;
                queue.add(new Pair<>(nx, ny));
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, vis[i][j]);
            }
        }

        System.out.println(max);
        br.close();
    }
}