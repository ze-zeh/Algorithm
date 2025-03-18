import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            hm.put(players[i], i);
        }
        
        for (String calling : callings) {
            int idx = hm.get(calling);
            String tmp = players[idx - 1];
            
            players[idx - 1] = players[idx];
            players[idx] = tmp;
            
            hm.put(calling, idx - 1);
            hm.put(tmp, idx);
        }
        
        return players;
    }
}