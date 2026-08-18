import java.util.*;

class Solution {
    static int N;
    static int[][][] dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public class Edge {
        int x;
        int y;
        int cost;
        int dir;
        
        Edge (int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
    
    public int solution(int[][] board) {
        N = board.length;
        dist = new int[N][N][4];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    dist[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        for (int i = 0; i < 4; i++) {
            dist[0][0][i] = 0;
        }
        
        dijkstra(board);
        
        return Math.min(dist[N - 1][N - 1][2], dist[N - 1][N - 1][3]);
    }

    public void dijkstra(int[][] board) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Edge(0, 0, 0, -1));
        
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int cost = 100;
                
                if (cur.dir != -1 && cur.dir % 2 != i % 2) {
                    cost = 600;
                }
                
                if (checkOpposite(cur.dir, i)
                    || !checkRange(nx, ny)
                    || board[nx][ny] == 1) {
                    continue;
                }
                
                if (dist[nx][ny][i] >= cur.cost + cost) {
                    dist[nx][ny][i] = cur.cost + cost;
                    pq.add(new Edge(nx, ny, cur.cost + cost, i));
                }
            }
        }
    }
    
    public boolean checkRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
    
    public boolean checkOpposite(int in, int out) {
        return (in == 1 && out == 3)
            || (in == 3 && out == 1)
            || (in == 0 && out == 2)
            || (in == 2 && out == 0);
    }
}