import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int capacity = 0;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();        
        
        for (int i = 0; i < enemy.length; i++) {
            sum += enemy[i];
            
            if (pq.size() < k) {
                pq.add(enemy[i]);
                capacity += enemy[i];
            } else {
                if (!pq.isEmpty() && pq.peek() < enemy[i]) {
                    capacity -= pq.poll();
                    capacity += enemy[i];
                    pq.add(enemy[i]);
                }
            }
            
            if (sum - capacity > n) {
                return i;
            }
        }
        
        
        return enemy.length;
    }
}