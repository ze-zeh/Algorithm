import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                maxHeap.add(x);
            } else {
                if (maxHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(maxHeap.poll());
                }
            }
        }

        br.close();
    }
}
