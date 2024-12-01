import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int length = words.length;
        Set<String> hs = new HashSet<>();
        char lastChar = words[0].charAt(0);
        
        for (int i = 0; i <= length / n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                
                if (idx >= length) break;
                
                if (hs.contains(words[idx]) || words[idx].charAt(0) != lastChar) {
                    return new int[]{j + 1, i + 1};
                }
                
                hs.add(words[idx]);
                lastChar = words[idx].charAt(words[idx].length() - 1);
            }
        }
        
        return new int[]{0, 0};
    }
}