import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();     
        int total = 0;
        int block = 0;
        
        for (int i = 0; i < enemy.length; i++) {
            total += enemy[i];
            block += enemy[i];
            pq.add(enemy[i]);
            
            if (pq.size() > k) {
                block -= pq.poll();
            }
            
            
            if (total - block > n) {
                return i;
            }
        }
        
        return enemy.length;
    }
}