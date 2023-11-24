import java.util.*;

class Solution {
    public class Pair {
        int x;
        int y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static boolean[][] Visited;
    public static String[][] Map;
    public static Queue<Pair> Q;
    public static int[] Dx = {0, 1, 0, -1};
    public static int[] Dy = {1, 0, -1, 0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            int result = 1;
            Visited = new boolean[5][5];
            Q = new LinkedList<>();
            Map = makeMap(places[i]);
            answer[i] = 1;
            
            while (!Q.isEmpty()) {
                Pair cur = Q.poll();
                
                if (!dfs(cur.x, cur.y, 0)) {
                    answer[i] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    public String[][] makeMap(String[] place) {
        String[][] result = new String[5][5];
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                char ch = place[i].charAt(j);
                result[i][j] = ch + "";
                
                if (ch == 'P') {
                    Q.add(new Pair(i, j));
                }
            }
        }
        
        return result;
    }
    
    public boolean dfs(int x, int y, int n) {
        if (x < 0 || x >= 5 || y < 0 || y >= 5 || Visited[x][y] || Map[x][y].equals("X") || n > 2) return true;
                
        if (Map[x][y].equals("P") && n > 0) {
            return false;
        }
        
        Visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + Dx[i];
            int ny = y + Dy[i];
            
            if (!dfs(nx, ny, n + 1)) {
                return false;
            }
        }
        
        return true;
    }
}