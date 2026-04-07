import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o1[1] - o2[1]);
        int N = Integer.parseInt(br.readLine());
        int answer = Integer.MAX_VALUE;
        int time = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            pq.add(new int[]{T, S});
        }

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            time += top[0];

            answer = Math.min(answer, top[1] - time);

            if (time > top[1]) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(answer != Integer.MAX_VALUE ? answer : -1);

        br.close();
    }
}
