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
        
        int[] arr = new int[hm.size()];
        int idx = 0;
        
        for (int i : hm.values()) {
            arr[idx++] = i;
        }
        
        Arrays.sort(arr);
        
        for (int i = arr.length - 1; i >= 0 && k > 0; i--) {
            answer++;
            k -= arr[i];
        }
        
        return answer;
    }
}