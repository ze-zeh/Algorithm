import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> hm = new HashMap<>();
        int answer = 0;
        
        for (int t : tangerine) {
            if (!hm.containsKey(t)) {
                hm.put(t, 0);
            }
            
            hm.put(t, hm.get(t) + 1);
        }
        
        List<Integer> list = new ArrayList<>(hm.values());
        Collections.sort(list, Collections.reverseOrder());
        
        for (int l : list) {
            answer++;
            k -= l;
            
            if (k <= 0) break;
        }
        
        return answer;
    }
}