import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hm = new HashMap<>();
        
        for (String[] item : clothes) {
            if (hm.containsKey(item[1])) {
                hm.put(item[1], hm.get(item[1]) + 1);
            } else {
                hm.put(item[1], 1);
            }
        }
        
        for (int value : hm.values()) {
            answer *= (value + 1);
        }
        
        return answer - 1;
    }
}