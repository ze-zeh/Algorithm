import java.util.*;

class Solution {
    static int[] Dx = {-1, 0, 1, 0};
    static int[] Dy = {0, -1, 0, 1};
    
    public class Point {
        int x;
        int y;
        int length;
        
        Point(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.add(new Point(0, 0, 1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            
            if (cur.x == n - 1 && cur.y == m - 1) {
                return cur.length;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + Dx[i];
                int ny = cur.y + Dy[i];
                
                if (nx >= n || nx < 0 || ny >= m || ny < 0 || maps[nx][ny] == 0|| visited[nx][ny]) {
                    continue;
                }
                
                queue.add(new Point(nx, ny, cur.length + 1));
                visited[nx][ny] = true;
            }
        }        
        
        return -1;
    }
}