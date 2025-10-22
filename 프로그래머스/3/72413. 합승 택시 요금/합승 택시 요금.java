import java.util.*;

class Solution {
    static List<List<Edge>> Adj;
    static int N;
    static final int INF = 10000001;
    
    class Edge {
        int to;
        int cost;
        
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        N = n;
        Adj = new ArrayList<>();
        s--;
        a--;
        b--;
        
        for (int i = 0; i < n; i++) {
            Adj.add(new ArrayList<>());
        }
        
        for (int[] fare : fares) {
            int x = fare[0] - 1;
            int y = fare[1] - 1;
            
            Adj.get(x).add(new Edge(y, fare[2]));
            Adj.get(y).add(new Edge(x, fare[2]));
        }
        
        int[] sCost = dijkstra(s);
        int[] aCost = dijkstra(a);
        int[] bCost = dijkstra(b);
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            
            sum += sCost[i];
            sum += aCost[i];
            sum += bCost[i];
            
            answer = Math.min(answer, sum);
        }
        
        print(sCost);
        print(aCost);
        print(bCost);
        
        return answer;
    }
    
    public int[] dijkstra(int start) {
        int[] cost = new int[N];
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        
        for (int i = 0; i < N; i++) {
            cost[i] = INF;
        }
        
        cost[start] = 0;
        pq.add(new Edge(start, 0));
        
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            
            for (Edge e : Adj.get(cur.to)) {
                if (cost[e.to] > cur.cost + e.cost) {
                    cost[e.to] = cur.cost + e.cost;
                    pq.add(new Edge(e.to, cost[e.to]));
                }
            }
        }
        
        return cost;
    }
    
    void print(int[] cost) {
        for (int i = 0; i < N; i++) {
            System.out.print(cost[i] + " ");
        }
        System.out.println();
    }
}