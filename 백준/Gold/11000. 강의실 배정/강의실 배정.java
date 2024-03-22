import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Pair[] arr = new Pair[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            arr[i] = new Pair(s, t);
        }

        Arrays.sort(arr, (l1, l2) -> l1.x == l2.x ? l1.y - l2.y : l1.x - l2.x);

        pq.offer(arr[0].y);

        for (int i = 1; i < n; i++) {
            if (pq.peek() <= arr[i].x) {
                pq.poll();
            }
            pq.offer(arr[i].y);
        }

        System.out.println(pq.size());
        br.close();
    }
}
