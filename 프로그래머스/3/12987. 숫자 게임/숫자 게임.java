import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> aHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> bHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < A.length; i++) {
            aHeap.add(A[i]);
            bHeap.add(B[i]);
        }
        
        while (!aHeap.isEmpty()) {
            if (aHeap.poll() < bHeap.peek()) {
                answer++;
                bHeap.poll();
            }
        }
        
        return answer;
    }
}