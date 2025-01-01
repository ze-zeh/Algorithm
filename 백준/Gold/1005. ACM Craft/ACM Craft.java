import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] D = new int[N + 1];
            int[] indegree = new int[N + 1];

            for (int j = 0; j <= N; j++) {
                adj.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                D[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                adj.get(X).add(Y);
                indegree[Y]++;
            }

            int W = Integer.parseInt(br.readLine());

            System.out.println(topologicalSort(indegree, adj, W, N, K, D));
        }

        br.close();
    }

    static int topologicalSort(int[] indegree, ArrayList<ArrayList<Integer>> adj, int W, int N, int K, int[] D) {
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            result[i] = D[i];

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Integer i : adj.get(node)) {
                result[i] = Math.max(result[i], result[node] + D[i]);
                indegree[i]--;

                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        return result[W];
    }
}