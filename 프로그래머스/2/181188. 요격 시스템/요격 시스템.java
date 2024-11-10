import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int end = 0;
        
        Arrays.sort(targets, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);
        
        for (int[] target : targets){
            if (end <= target[0]){
                end = target[1];
                answer++;
            }
        }
        
        return answer;
    }
}