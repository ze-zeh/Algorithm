class Solution {
    static int M, N;
    static char[][] Board;
    static boolean[][] map;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        boolean flag = true;
        Board = new char[m][n];
        M = m;
        N = n;
        
        for (int i = 0; i < M; i++) {
            String row = board[i];
            
            for (int j = 0; j < N; j++) {
                Board[i][j] = row.charAt(j);
            }
        }
        
        while (flag) {
            map = new boolean[M][N];
            flag = false;
            
            for (int i = 0; i < M - 1; i++) {
                for (int j = 0; j < N - 1; j++) {                    
                    if (check(i, j)) {
                        flag = true;
                    }
                }
            }
            
            answer += clear();
            slide();
        }
        
        return answer;
    }
    
    public boolean check(int x, int y) {
        char ch = Board[x][y];
        
        if (ch == '0') {
            return false;
        }
        
        if (ch == Board[x][y + 1] && ch == Board[x + 1][y] && ch == Board[x + 1][y + 1]) {
            map[x][y] = true;
            map[x][y + 1] = true;
            map[x + 1][y] = true;
            map[x + 1][y + 1] = true;
            
            return true;
        }
        
        return false;
    }
    
    public int clear() {
        int count = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]) {
                    count++;
                    Board[i][j] = '0';
                }
            }
        }
        
        return count;
    }
    
    public void slide() {
        for (int i = 0; i < N; i++) {
            for (int j = M - 1; j >= 1; j--) {
                if (Board[j][i] == '0') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (Board[k][i] != '0') {
                            Board[j][i] = Board[k][i];
                            Board[k][i] = '0';
                            break;
                        }
                    }
                }
            }
        }
    }
}