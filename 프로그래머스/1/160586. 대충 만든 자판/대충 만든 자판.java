import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> hm = new HashMap<>();
        
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                
                if (!hm.containsKey(ch) || hm.get(ch) > i + 1) {
                    hm.put(ch, i + 1);
                }
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int count = 0;
            boolean isDisabled = false;
            
            for (int j = 0; j < target.length(); j++) {
                char ch = target.charAt(j);
                
                if (!hm.containsKey(ch)) {
                    isDisabled = true;
                    break;
                }
                
                count += hm.get(ch);
            }
            
            answer[i] = isDisabled ? -1 : count;
        }
        
        return answer;
    }
}