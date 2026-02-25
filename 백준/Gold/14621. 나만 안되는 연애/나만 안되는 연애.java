import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static int[] p;

    public static class Edge {
        int start;
        int end;
        int dist;

        Edge(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] genders = new boolean[N];
        p = new int[N];
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        int count = 0;
        int answer = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            String gender = st.nextToken();

            if (gender.equals("M")) {
                genders[i] = true;
            }

            p[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            pq.add(new Edge(u, v, d));
        }

        while (count != N - 1) {
            Edge cur = pq.poll();

            if (cur == null) {
                System.out.println(-1);
                return;
            }

            if (genders[cur.start] != genders[cur.end] && union(cur.start, cur.end)) {
                answer += cur.dist;
                count++;
            }
        }

        System.out.println(answer);

        br.close();
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return false;
        }

        if (x > y) {
            p[x] = y;
        } else {
            p[y] = x;
        }

        return true;
    }

    public static int find(int i) {
        if (i == p[i]) {
            return i;
        }

        p[i] = find(p[i]);

        return p[i];
    }
}
