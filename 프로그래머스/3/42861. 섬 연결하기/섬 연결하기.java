import java.util.*;

class Solution {
    static int[] p;
    
    class Edge {
        int s;
        int e;
        int w;
        
        Edge (int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        p = new int[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        
        for (int[] cost : costs) {
            pq.add(new Edge(cost[0], cost[1], cost[2]));
        }
        
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (union(cur.s, cur.e)) {
                answer += cur.w;
            }
        }      
        
        return answer;
    }
    
    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x == y) {
            return false;
        }
        
        if (x > y) {
            p[x] = y;
        } else {
            p[y] = x;
        }
        
        return true;
    }
    
    public static int find(int x) {
        if (x == p[x]) {
            return x;
        }
        
        p[x] = find(p[x]);
        
        return p[x];
    }
}