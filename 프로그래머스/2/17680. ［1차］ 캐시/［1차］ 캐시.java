import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new LinkedList<>();
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (String c : cities) {
            String city = c.toLowerCase();
            
            answer += cache.contains(city) ? 1 : 5;
            cache.remove(city);
            if (cache.size() >= cacheSize) cache.remove(0);
            cache.add(city);
        }
        
        return answer;
    }
}