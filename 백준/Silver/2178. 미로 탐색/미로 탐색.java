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
        int[][] maze = new int[n][m];
        int[][] vis = new int[n][m];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j] = -1;
            }
        }

        vis[0][0] = 1;
        queue.add(new Pair<>(0, 0));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.getKey() + dx[k];
                int ny = cur.getValue() + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (vis[nx][ny] != -1 || maze[nx][ny] != 1) continue;
                vis[nx][ny] = vis[cur.getKey()][cur.getValue()] + 1;
                queue.add(new Pair<>(nx, ny));
            }
        }

        bw.write(String.valueOf(vis[n - 1][m - 1]));
        bw.flush();
        bw.close();
        br.close();
    }
}