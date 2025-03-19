import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        for (int i : ingredient) {
            list.add(i);
            
            if (list.size() < 4) continue;
            
            boolean first = list.get(list.size() - 4) == 1;
            boolean second = list.get(list.size() - 3) == 2;
            boolean third = list.get(list.size() - 2) == 3;
            boolean fourth = list.get(list.size() - 1) == 1;
                
            if (first && second && third && fourth) {
                answer++;
                    
                for (int j = 0; j < 4; j++) {
                    list.remove(list.size() - 1);
                }
            }
        }
        
        return answer;
    }
}