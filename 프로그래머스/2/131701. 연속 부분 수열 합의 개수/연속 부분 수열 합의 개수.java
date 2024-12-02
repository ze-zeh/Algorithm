import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> hs = new HashSet<>();
        int n = elements.length;
        
        for (int i = 0; i < n; i++) { // 시작 인덱스
            for (int j = 1; j <= n; j++) { // 길이
                int sum = 0;
                
                for (int k = 0; k < j; k++) {
                    sum += elements[(i + k) % n];
                }
                
                hs.add(sum);
            }
        }
        
        return hs.size();
    }
}