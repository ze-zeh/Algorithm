class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            dfsSolve(board, i, 0);
            dfsSolve(board, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            dfsSolve(board, 0, i);
            dfsSolve(board, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                if (board[i][j] == 'E')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfsSolve(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') return;

        board[x][y] = 'E';

        for (int i = 0; i < 4; i++) {
            dfsSolve(board, x + dx[i], y + dy[i]);
        }
    }
}