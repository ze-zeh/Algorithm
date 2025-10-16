import java.util.*;

class Solution {
    public String solution(String p) {
        return recur(p);
    }
    
    public String recur(String s) {
        String u = "";
        String v = "";
        int a = 0;
        int b = 0;
        
        if (s.length() == 0) {
            return s;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                a++;
            } else {
                b++;
            }
            
            if (a == b) {
                u = s.substring(0, i + 1);
                v = s.substring(i + 1, s.length());
                break;
            }
        }
        
        if (check(u)) {
            return u + recur(v);
        } else {
            String str = "(";
            str += recur(v);
            str += ")";
            str += reverse(u.substring(1, u.length() - 1));
            
            return str;
        }
    }
    
    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add('(');
            } else {
                if (stack.size() > 0 && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        if (stack.size() > 0) {
            return false;
        }
        
        return true;
    }
    
    public String reverse(String str) {
        str = str.replace('(', '*');
        str = str.replace(')', '(');
        str = str.replace('*', ')');
        return str;
    }
}