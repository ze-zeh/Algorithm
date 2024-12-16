import java.util.*;

class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int answer = 0;
        int[][] dp = new int[n + 1][4];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (k != j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + land[i - 1][k]);
                    }
                }
            }
        }
        
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[n][i]);
        }

        return answer;
    }
}