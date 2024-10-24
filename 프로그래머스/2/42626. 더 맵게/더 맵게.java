import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.add(s);
        }
        
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            
            answer++;
            
            int first = pq.poll();
            int second = pq.poll();
            
            pq.add(first + second * 2);
        }
        
        return answer;
    }
}