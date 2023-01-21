import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, M, V;
    static int[][] link;
    static boolean[] vis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        link = new int[N + 1][N + 1];
        vis = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            link[a][b] = 1;
            link[b][a] = 1;
        }

        dfs(V);
        vis = new boolean[N + 1];
        System.out.println();
        bfs();
        br.close();
    }

    public static void dfs(int V) {
        vis[V] = true;
        System.out.print(V + " ");

        for (int i = 0; i <= N; i++) {
            if (vis[i]) continue;
            if (link[V][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        vis[V] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");

            for (int i = 1; i <= N; i++) {
                if (vis[i]) continue;
                if (link[cur][i] == 1) {
                    queue.add(i);
                    vis[i] = true;
                }
            }
        }
        System.out.println();
    }
}