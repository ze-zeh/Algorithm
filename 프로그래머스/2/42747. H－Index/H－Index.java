import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        int h = n;
        
        Arrays.sort(citations);
        
        for (int i = n; i >= 1; i--) {
            int count = 0;
            
            for (int j = n - 1; j >= 0; j--) {
                if (citations[j] >= i) {
                    count++;
                } else {
                    if (count < n) {
                        break;
                    }
                }
            }
            
            if (count >= i) {
                return i;
            }
        }
        
        return 0;
    }
}