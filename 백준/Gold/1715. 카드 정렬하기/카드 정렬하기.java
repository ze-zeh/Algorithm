import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue();
        int result = 0;

        for (int i = 0; i < n; i++) {
            pq.add(input.nextInt());
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            result += a + b;
            pq.add(a + b);
        }

        System.out.println(result);
    }
}