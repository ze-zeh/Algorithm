import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) {
            pq.add(work);
        }
        
        while (n > 0) {
            if (pq.peek() == 0) break;
            
            pq.add(pq.poll() - 1);
            n--;
        }
        
        for (int i = 0; i < works.length; i++) {
            answer += pow(pq.poll());
        }
        
        return answer;
    }
    
    public int pow(int num) {
        return num * num;
    }
}