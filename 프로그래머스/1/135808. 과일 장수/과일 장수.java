import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int n = score.length;
        
        Arrays.sort(score);
        
        for (int i = n - 1; i >= m - 1; i -= m) {
            answer += score[i - m + 1] * m;
        }
        
        return answer;
    }
}