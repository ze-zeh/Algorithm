import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int last = Integer.MIN_VALUE;
        
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        for(int[] route : routes) {
            if(last < route[0]) {
                last = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}