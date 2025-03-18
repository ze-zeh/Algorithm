import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<Integer, String> numMap = new HashMap<>();
        Map<String, Integer> nameMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            numMap.put(i, players[i]);
            nameMap.put(players[i], i);
        }
        
        for (String calling : callings) {
            int num = nameMap.get(calling);
            String frontName = numMap.get(num - 1);
            
            nameMap.put(frontName, num);
            nameMap.put(calling, num - 1);
            numMap.put(num - 1, calling);
            numMap.put(num, frontName);
        }
        
        for (int i = 0; i < numMap.size(); i++) {
            answer[i] = numMap.get(i);
        }
        
        return answer;
    }
}