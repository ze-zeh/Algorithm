import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] adj = new boolean[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u][v] = true;
            adj[v][u] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            queue.add(i);
            visited[i] = true;
            count++;

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int j = 1; j <= n; j++) {
                    if (adj[cur][j] && !visited[j]) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
        }

        System.out.println(count);

        br.close();
    }
}
