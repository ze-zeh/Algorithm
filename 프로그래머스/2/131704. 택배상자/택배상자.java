import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < order.length; i++) {       
            stack.add(i + 1);
            
            while (!stack.isEmpty() && order[answer] == stack.peek()) {
                stack.pop();
                answer++;
            }
        }
        
        return answer;
    }
}