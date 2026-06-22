import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int last = 0;
        
        Arrays.sort(targets,(o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o1[1] - o2[1]);
        
        for (int[] target : targets) {
            if (last <= target[0]) {
                last = target[1];
                answer++;
            }
        }
        
        return answer;
    }
}