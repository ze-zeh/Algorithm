import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }
        
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}