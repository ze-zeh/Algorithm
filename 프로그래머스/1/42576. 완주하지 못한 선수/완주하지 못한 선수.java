import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> hm = new HashMap<>();
        
        for (String name : completion) {
            if (hm.containsKey(name)) {
                hm.put(name, hm.get(name) + 1);
            } else {
                hm.put(name, 1);
            }
        }
        
        for (String name : participant) {
            if (hm.containsKey(name) && hm.get(name) > 0) {
                hm.put(name, hm.get(name) - 1);
            } else {
                return name;
            }
        }
        
        return "";
    }
}