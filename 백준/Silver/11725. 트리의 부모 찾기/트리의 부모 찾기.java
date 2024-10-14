import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : adj.get(cur)) {
                if (visited[next]) continue;

                visited[next] = true;
                queue.add(next);
                result[next] = cur;
            }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(result[i]);
        }

        br.close();
    }
}