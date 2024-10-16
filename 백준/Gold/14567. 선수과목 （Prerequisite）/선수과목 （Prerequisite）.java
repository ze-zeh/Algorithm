import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] indegree = new int[N + 1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
            result[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj.get(A).add(B);
            indegree[B]++;
        }

        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Integer i : adj.get(node)) {
                indegree[i]--;

                if (indegree[i] == 0) {
                    queue.offer(i);
                    result[i] += result[node];
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(result[i] + " ");
        }

        br.close();
    }
}