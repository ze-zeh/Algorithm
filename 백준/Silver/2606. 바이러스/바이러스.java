import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];
        boolean[] infested = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int count = -1;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = true;
            arr[b][a] = true;
        }

        queue.add(1);
        infested[1] = true;
        visited[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && arr[cur][i] && i != cur) {
                    infested[i] = true;
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (infested[i]) count++;
        }

        System.out.println(count);

        br.close();
    }
}
