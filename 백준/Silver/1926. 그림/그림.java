import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] paint = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int max = 0;
        int num = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paint[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] || paint[i][j] != 1) continue;
                int count = 0;
                num++;
                vis[i][j] = true;
                queue.add(new Pair<>(i, j));
                while (!queue.isEmpty()) {
                    count++;
                    Pair<Integer, Integer> cur = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.getKey() + dx[k];
                        int ny = cur.getValue() + dy[k];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (vis[nx][ny] || paint[nx][ny] != 1) continue;
                        vis[nx][ny] = true;
                        queue.offer(new Pair<>(nx, ny));
                    }
                }
                max = Math.max(max, count);
            }
        }

        bw.write(num + "\n" + max);
        bw.flush();
        bw.close();
        br.close();
    }
}