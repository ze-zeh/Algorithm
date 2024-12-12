import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> hm1 = new HashMap<>();
        Map<Integer, Integer> hm2 = new HashMap<>();
        
        for (int t : topping) {
            hm2.put(t, hm2.getOrDefault(t, 0) + 1);
        }
        
        for (int t : topping) {
            hm1.put(t, hm1.getOrDefault(t, 0) + 1);
            
            if (hm2.get(t) == 1) {
                hm2.remove(t);
            } else {
                hm2.put(t, hm2.get(t) - 1);
            }
            
            if (hm1.size() == hm2.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}