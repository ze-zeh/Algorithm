import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        if (s.length() % 2 == 1) return 0;
        
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.substring(0, 1);
            answer += check(s) ? 1 : 0;
        }
        
        return answer;
    }
    
    public boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            
            if (stack.size() > 0) {
                char top = stack.peek();
                
                if ((top == '(' && cur == ')') || (top == '[' && cur == ']') || (top == '{' && cur == '}')) {
                    stack.pop();
                } else {
                    stack.add(cur);
                }
            } else {
                stack.add(cur);
            }
        }
        
        return stack.size() == 0;
    }
}