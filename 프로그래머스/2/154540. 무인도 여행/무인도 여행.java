import java.util.*;

class Solution {
    static int N, M;
    static PriorityQueue<Integer> pq;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public int[] solution(String[] maps) {
        pq = new PriorityQueue<>();
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String s = maps[i];
            
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'X') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = s.charAt(j) - '0';
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    pq.add(bfs(i, j));
                }
            }
        }
        
        return getAnswer();
    }
    
    public int bfs(int sx, int sy) {
        Queue<int[]> queue = new LinkedList<>();
        int sum = map[sx][sy];
        
        queue.add(new int[] {sx, sy});
        visited[sx][sy] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (!checkRange(nx, ny) || visited[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }
                
                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny});
                sum += map[nx][ny];
            }
        }
        
        return sum;
    }
    
    public boolean checkRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    
    public int[] getAnswer() {
        if (pq.size() == 0) {
            return new int[] {-1};
        }
        
        int[] answer = new int[pq.size()];
        int i = 0;
        
        while (!pq.isEmpty()) {
            answer[i++] = pq.poll();
        }
        
        return answer;
    }
}