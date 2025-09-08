import java.util.*;

class Solution {
    final int INF = 1_000_000_000;
    
    public int solution(int[][] info, int n, int m) {
        int answer = INF;
        int length = info.length;
        int[][] dp = new int[length + 1][m];
        
        for(int i = 0; i <= length; i++){
            Arrays.fill(dp[i], INF);
        }
        
        dp[0][0] = 0;
        
        for (int i = 1; i <= length ; i++) {
            for (int j = 0; j < m; j++) {
                int a = info[i - 1][0];
                int b = info[i - 1][1];
                
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);
                
                if (j + b < m) {
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i - 1][j]);
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            answer = Math.min(answer, dp[length][i]);
        }
        
        return answer < n ? answer : -1;
    }
}
