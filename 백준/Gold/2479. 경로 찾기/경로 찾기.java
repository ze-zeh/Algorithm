import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, A, B;
    static int[] hc;
    static List<List<Integer>> adj;

    static class Route {
        int code;
        int dist;
        String route;

        public Route(int code) {
            this.code = code;
            this.dist = 1;
            this.route = (code + 1) + "";
        }

        public Route(int code, int dist, String route) {
            this.code = code;
            this.dist = dist;
            this.route = route + " " + (code + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        hc = new int[N];
        adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            hc[i] = Integer.parseInt(br.readLine(), 2);
            adj.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()) - 1;
        B = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && isAdj(i, j)) {
                    adj.get(i).add(j);
                }
            }
        }

        bfs();
        br.close();
    }

    public static boolean isAdj(int x, int y) {
        int xor = hc[x] ^ hc[y];
        return xor != 0 && (xor & (xor - 1)) == 0;
    }

    public static void bfs() {
        Queue<Route> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        queue.add(new Route(A));
        visited[A] = true;

        while (!queue.isEmpty()) {
            Route cur = queue.poll();

            if (cur.code == B) {
                System.out.println(cur.route);
                return;
            }

            for (int a : adj.get(cur.code)) {
                if (!visited[a]) {
                    queue.add(new Route(a, cur.dist + 1, cur.route));
                    visited[a] = true;
                }
            }
        }

        System.out.println(-1);
    }
}