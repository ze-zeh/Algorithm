import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            hm.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i++) {
            for (String person : photo[i]) {
                if (hm.containsKey(person)) {
                    answer[i] += hm.get(person);
                }
            }
        }
        
        return answer;
    }
}