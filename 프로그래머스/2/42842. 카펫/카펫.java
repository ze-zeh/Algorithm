import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for (int h = 3; h <= Math.sqrt(sum); h++) {
            if (sum % h == 0) {
                int w = sum / h;
                
                if ((w - 2) * (h - 2) == yellow) {
                    answer[0] = w;
                    answer[1] = h;
                }
            }
        }
        
        return answer;
    }
}