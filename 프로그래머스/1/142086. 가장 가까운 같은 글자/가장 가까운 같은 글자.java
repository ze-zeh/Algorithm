import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            answer.add((hm.get(ch) != null) ? i - hm.get(ch) : -1);
            hm.put(ch, i);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}