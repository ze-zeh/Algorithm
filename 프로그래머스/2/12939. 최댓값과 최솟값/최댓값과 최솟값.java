import java.util.*;

class Solution {
    public String solution(String s) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(s);
        
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            
            maxHeap.add(num);
            minHeap.add(num);
        }
        
        return minHeap.peek() + " " + maxHeap.peek();
    }
}