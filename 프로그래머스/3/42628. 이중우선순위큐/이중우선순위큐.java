import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            String command = st.nextToken();
            int data = Integer.parseInt(st.nextToken());
            
            if (command.equals("I")) {
                maxHeap.add(data);
                minHeap.add(data);
            } else {
                if (maxHeap.size() == 0) {
                    continue;
                }
                
                if (data == 1) {
                    minHeap.remove(maxHeap.poll());
                } else {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }
        
        if (maxHeap.size() == 0) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxHeap.peek(), minHeap.peek()};
        }
    }
}