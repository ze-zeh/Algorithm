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
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Character[][] maze = new Character[r][c];
        int[][] vis = new int[r][c];
        int[][] fireVis = new int[r][c];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Queue<Pair<Integer, Integer>> fire = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                maze[i][j] = str.charAt(j);
                if (maze[i][j] == 'J') {
                    queue.add(new Pair<>(i, j));
                    vis[i][j] = 0;
                } else {
                    vis[i][j] = -1;
                }

                if (maze[i][j] == 'F') {
                    fire.add(new Pair<>(i, j));
                    fireVis[i][j] = 0;
                } else {
                    fireVis[i][j] = -1;
                }
            }
        }

        while (!fire.isEmpty()) {
            Pair<Integer, Integer> cur = fire.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.getKey() + dx[k];
                int ny = cur.getValue() + dy[k];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (fireVis[nx][ny] >= 0 || maze[nx][ny] == '#') continue;
                fireVis[nx][ny] = fireVis[cur.getKey()][cur.getValue()] + 1;
                fire.add(new Pair<>(nx, ny));
            }
        }

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.getKey() + dx[k];
                int ny = cur.getValue() + dy[k];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    System.out.println(vis[cur.getKey()][cur.getValue()] + 1);
                    return;
                }
                if (vis[nx][ny] >= 0 || maze[nx][ny] == '#') continue;
                if (fireVis[nx][ny] != -1 && fireVis[nx][ny] <= vis[cur.getKey()][cur.getValue()] + 1) continue;
                vis[nx][ny] = vis[cur.getKey()][cur.getValue()] + 1;
                queue.add(new Pair<>(nx, ny));
            }
        }

        System.out.print("IMPOSSIBLE");
        br.close();
    }
}