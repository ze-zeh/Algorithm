import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, A, B;
    static int[] hc;
    static List<List<Integer>> adj;
    static int[] d;

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
        d = new int[K];
        adj = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            String s = "";

            for (int j = 0; j < K; j++) {
                if (i == j) {
                    s += "1";
                } else {
                    s += "0";
                }
            }

            d[i] = Integer.parseInt(s, 2);
        }

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

        dijkstra();
        br.close();
    }

    public static boolean isAdj(int x, int y) {
        int adj = hc[x] ^ hc[y];

        for (int i = 0; i < K; i++) {
            if (adj == d[i]) {
                return true;
            }
        }

        return false;
    }

    public static void dijkstra() {
        PriorityQueue<Route> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        boolean[] visited = new boolean[N];
        pq.add(new Route(A));
        visited[A] = true;

        while (!pq.isEmpty()) {
            Route cur = pq.poll();
            visited[cur.code] = true;

            if (cur.code == B) {
                System.out.println(cur.route);
                return;
            }

            for (int a : adj.get(cur.code)) {
                if (!visited[a]) {
                    pq.add(new Route(a, cur.dist + 1, cur.route));
                }
            }
        }

        System.out.println(-1);
    }
}