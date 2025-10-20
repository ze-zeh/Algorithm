import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int m = money.length;
        int[][] dp = new int[m + 1][n + 1];
        
        Arrays.sort(money);
        
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= money[i - 1]) {
                    dp[i][j] = (dp[i][j - money[i - 1]] + dp[i - 1][j]) % 1000000007;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}