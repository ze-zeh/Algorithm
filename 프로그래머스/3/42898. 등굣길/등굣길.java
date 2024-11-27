class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m + 1][n + 1];
        
        dp[1][1] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i == 1 && j == 1)) continue;
                
                if (checkPuddles(i, j, puddles)) {
                    dp[i][j] = 0;
                    continue;
                }
                
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }
        
        return dp[m][n];
    }
    
    public boolean checkPuddles(int x, int y, int[][] puddles) {
        for (int[] puddle : puddles) {
            if (x == puddle[0] && y == puddle[1]) {
                return true;
            }
        }
        
        return false;
    }
}