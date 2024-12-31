import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String str = "";
        int num = 0;
        
        while (str.length() < m * t + p - 1) {
            str += changeNum(n, num++);
        }
        
        for (int i = 0; i < t; i++) {
            answer += str.charAt(i * m + p - 1);
        }
        
        return answer;
    }
    
    String changeNum(int n, int num) {
        StringBuilder result = new StringBuilder();
        
        if (num == 0) {
            return "0";
        }
        
        while (num > 0) {
            int r = num % n;
            
            if (r >= 10) {
                result.append((char) ('A' + r - 10));
            } else {
                result.append(r);
            }

            num /= n;
        }

        return result.reverse().toString();
    }
}