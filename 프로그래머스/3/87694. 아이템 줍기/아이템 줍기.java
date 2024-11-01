import java.util.*;

class Solution {
    static char[][] Map = new char[101][101];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] r : rectangle) {
            for (int x = r[0] * 2; x <= r[2] * 2; x++) {
                for (int y = r[1] * 2; y <= r[3] * 2; y++) {
                    if (Map[x][y] == '1') continue;
                    Map[x][y] = '1';
                    
                    if(x == r[0] * 2 || x == r[2] * 2 || y == r[1] * 2 || y == r[3] * 2) {
                        Map[x][y] = '2';
                    }
                }
            }
        }
        
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    
    public int bfs(int characterX, int characterY, int itemX, int itemY) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        
        queue.add(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[0] == itemX && cur[1] == itemY) {
                return cur[2] / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || nx >= 101 || ny < 0 || ny >= 101 || visited[nx][ny] || Map[nx][ny] != '2') continue;
                
                queue.add(new int[]{nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
            }
        }
        
        return 0;
    }
}