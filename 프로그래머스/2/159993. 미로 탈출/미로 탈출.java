import java.util.*;

class Solution {
    static int SX, SY;
    static int EX, EY;
    static int LX, LY;
    static int N, M;
    static int Answer = 0;
    static boolean[][] Map;
    static boolean[][] Visited;
    static int[] Dx = {-1, 0, 1, 0};
    static int[] Dy = {0, -1, 0, 1};
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        Map = new boolean[N][M];
        Visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char ch = maps[i].charAt(j);
                
                if (ch == 'S') {
                    SX = i;
                    SY = j;
                }
                
                if (ch == 'E') {
                    EX = i;
                    EY = j;
                }
                
                if (ch == 'L') {
                    LX = i;
                    LY = j;
                }
                
                if (ch != 'X') {
                    Map[i][j] = true;
                }
            }
        }
        
        if (bfs(SX, SY, LX, LY)) {
            Visited = new boolean[N][M];
            
            if (bfs(LX, LY, EX, EY)) {
                return Answer;
            }
        }
        
        return -1;
    }
    
    public boolean bfs(int sx, int sy, int ex, int ey) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy, 0});
        Visited[sx][sy] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[0] == ex && cur[1] == ey) {
                Answer += cur[2];
                return true;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + Dx[i];
                int ny = cur[1] + Dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !Visited[nx][ny] && Map[nx][ny]) {
                    queue.add(new int[]{nx, ny, cur[2] + 1});
                    Visited[nx][ny] = true;
                }
            }
        }
        
        return false;
    }
}