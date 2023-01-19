import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    private static final int MAX_SIZE = 100_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] vis = new int[MAX_SIZE + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i <= MAX_SIZE; i++) {
            vis[i] = -1;
        }

        vis[n] = 0;
        queue.add(n);

        while (vis[k] == -1) {
            int cur = queue.poll();
            for (int nx : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (nx < 0 || nx > MAX_SIZE) continue;
                if (vis[nx] != -1) continue;
                vis[nx] = vis[cur] + 1;
                queue.add(nx);
            }
        }
        System.out.print(vis[k]);
        br.close();
    }
}