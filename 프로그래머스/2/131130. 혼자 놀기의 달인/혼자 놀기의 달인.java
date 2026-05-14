import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] visited = new boolean[cards.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < cards.length; i++) {
            cards[i]--;
        }
        
        for (int i = 0; i < cards.length; i++) {
            int index = i;
            int count = 0;
            
            if (visited[index]) {
                continue;
            }
            
            while (cards[index] != index && !visited[index]) {
                visited[index] = true;
                index = cards[index];
                count++;
            }
            
            pq.add(Math.max(count, 1));
        }
        
        if (pq.size() > 1) {
            return pq.poll() * pq.poll();    
        }
        
        return 0;
    }
}