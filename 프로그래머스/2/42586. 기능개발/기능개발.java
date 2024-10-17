import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int count = 1;
        
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            
            if ((100 - progresses[i]) % speeds[i] > 0) {
                day++;
            }
            
            if (stack.isEmpty()) {
                count = 1;
                stack.add(day);
            } else {
                if (stack.peek() < day) {
                    stack.add(day);
                    answer.add(count);
                    count = 1;
                } else {
                    count++;
                }
            }
        }
        
        answer.add(count);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}