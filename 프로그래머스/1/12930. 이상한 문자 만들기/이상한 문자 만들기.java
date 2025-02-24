import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        
        s = s.toLowerCase();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == ' ') {
                idx = 0;
                answer += ch;
                continue;
            }
            
            if (idx % 2 == 0) {
                ch += 'A' - 'a';
            }
            
            idx++;
            answer += ch;
        }
        
        return answer;
    }
}