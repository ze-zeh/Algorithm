import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int box = 1;
        int idx = 0;
        
        while (idx < order.length && box <= order.length) {            
            if (order[idx] == box) {
                answer++;
                box++;
                idx++;
            } else {
                stack.add(box);
                box++;
            }
            
            while (!stack.isEmpty() && order[idx] == stack.peek()) {
                stack.pop();
                answer++;
                idx++;
            }
        }
        
        return answer;
    }
}