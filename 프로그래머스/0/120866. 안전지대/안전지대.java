class Solution {
    static int N;
    static int[] Dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    static int[] Dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    static int[][] Map;
    
    public int solution(int[][] board) {
        N = board.length;
        Map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    findMine(i, j);
                }
            }
        }
        
        return countMap();
    }
    
    static void findMine(int x, int y) {
        for (int i = 0; i < 9; i++) {
            int nx = x + Dx[i];
            int ny = y + Dy[i];
                
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                Map[nx][ny] = 1;
            }
        }
    }
    
    static int countMap() {
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Map[i][j] == 0) count++;
            }
        }
        
        return count;
    }
}