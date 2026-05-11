import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int n = minerals.length;
        int size = n / 5 + 1;
        int index = 0;
        int[][] dx = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        int max = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> 
                    o1[0] != o2[0] ? o2[0] - o1[0] : (
                        o1[1] != o2[1] ? o2[1] - o1[1] : o2[2] - o1[2]
                    ));
        
        for (int p : picks) {
            max += p;
        }
        
        while (index < max) {
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            
            for (int i = 0; i < 5; i++) {
                if (index * 5 + i >= n) {
                    break;
                }
                
                String mineral = minerals[index * 5 + i];
                
                if (mineral.equals("diamond")) {
                    diamond++;
                } else if (mineral.equals("iron")) {
                    iron++;
                } else if (mineral.equals("stone")) {
                    stone++;
                }
            }
            
            pq.add(new int[] {diamond, iron, stone});
            index++;
        }
        
        int p = 0;
        
        while (!pq.isEmpty()) {
            int[] price = pq.poll();
            int pick = 0;
            
            if (picks[0] > 0) {
                pick = 0;
                picks[0]--;
            } else if (picks[1] > 0) {
                pick = 1;
                picks[1]--;
            } else if (picks[2] > 0) {
                pick = 2;
                picks[2]--;
            } else {
                break;
            }
            
            answer += price[0] * dx[pick][0] + price[1] * dx[pick][1] + price[2] * dx[pick][2];
        }
        
        return answer;
    }
}