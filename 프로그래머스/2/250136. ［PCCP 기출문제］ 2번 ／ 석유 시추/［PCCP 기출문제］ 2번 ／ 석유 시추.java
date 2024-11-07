import java.util.*;

class Solution {
    static int[] Dx = {-1, 0, 1, 0};
    static int[] Dy = {0, -1, 0, 1};
    static boolean[][] Visited;
    static int M;
    static int N;
    static int[] Memo;
    
    public int solution(int[][] land) {
        int answer = 0;
        M = land[0].length;
        N = land.length;
        Visited = new boolean[N][M];
        Memo = new int[M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Visited[i][j] || land[i][j] == 0) continue;
                
                bfs(land, i, j); 
            }
        }
        
        for (int num : Memo) {
            answer = Math.max(answer, num);
        }
        
        return answer;
    }
    
    public int bfs(int[][] land, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int count = 1;
        
        queue.add(new int[]{row, col});
        Visited[row][col] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();                        
            set.add(cur[1]);
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + Dx[i];
                int ny = cur[1] + Dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || Visited[nx][ny] || land[nx][ny] == 0) {
                    continue;
                }
                
                queue.add(new int[]{nx, ny});
                Visited[nx][ny] = true;
                count++;
            }
        }
        
        for(int n : set) {
            Memo[n] += count;
        }
        
        return count;
    }
}