
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isFirst = true;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == ' ') {
                isFirst = true;
                answer.append(" ");
                continue;
            }
            
            if (isFirst) {
                if (ch >= 'a' && ch <= 'z') {
                    ch += 'A' - 'a';
                }
            } else {
                if (ch >= 'A' && ch <= 'Z') {
                    ch -= 'A' - 'a';
                }
            }
            
            isFirst = false;
            answer.append(ch);
        }

        return answer.toString();
    }
}