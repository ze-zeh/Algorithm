class Solution {
    public static int N;
    public static boolean[][] Adj;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        N = n;
        Adj = new boolean[n][n];
        
        for (int[] result : results) {
            Adj[result[0] - 1][result[1] - 1] = true;
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Adj[i][j] = Adj[i][j] || (Adj[i][k] && Adj[k][j]);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (isKnow(i)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isKnow(int a) {
        for (int i = 0; i < N; i++) {
            if (a != i && !Adj[a][i] && !Adj[i][a]) {
                return false;
            }
        }
        
        return true;
    }
}