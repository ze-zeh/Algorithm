import java.util.*;

class Solution {
    static int N, M;
    final static int BLANK = 0;
    final static int WALL = 1;
    final static int END = 2;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        int[][] map = new int[N][M];
        int sx = 0;
        int sy = 0;
        
        for (int i = 0; i < N; i++) {
            String b = board[i];
            
            for (int j = 0; j < M; j++) {
                char ch = b.charAt(j);
                
                if (ch == 'R') {
                    map[i][j] = BLANK;
                    sx = i;
                    sy = j;
                } else if (ch == 'G') {
                    map[i][j] = END;
                } else if (ch == 'D') {
                    map[i][j] = WALL;
                } else {
                    map[i][j] = BLANK;
                }
            }
        }
        
        return bfs(map, sx, sy);
    }
    
    public int bfs(int[][] map, int sx, int sy) {
        boolean[][] visited = new boolean[N][M];
        int depth = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int curx = cur[0];
                int cury = cur[1];
                
                while (true) {
                    int nx = curx + dx[i];
                    int ny = cury + dy[i];
                    
                    if (!checkRange(nx, ny) || map[nx][ny] == WALL) {
                        break;
                    }
                    
                    curx = nx;
                    cury = ny;
                }
                
                if (visited[curx][cury]) {
                    continue;
                }
                
                if (map[curx][cury] == END) {
                    return cur[2] + 1;
                }
                
                queue.add(new int[] {curx, cury, cur[2] + 1});
                visited[curx][cury] = true;
            }
        }
        
        return -1;
    }
    
    public boolean checkRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}