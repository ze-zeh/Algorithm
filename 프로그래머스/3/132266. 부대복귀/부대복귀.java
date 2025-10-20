import java.util.*;

class Solution {    
    class Edge {
        int to;
        int cost;
        
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] dist = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[destination - 1] = 0;
        pq.add(new Edge(destination - 1, 0));
        
        for (int[] road : roads) {
            int u = road[0] - 1;
            int v = road[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            
            for (int node : adj.get(cur.to)) {
                if (dist[node] > cur.cost + 1) {
                    dist[node] = cur.cost + 1;
                    pq.add(new Edge(node, dist[node]));
                }
            }
        }
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = dist[sources[i] - 1] != Integer.MAX_VALUE ? dist[sources[i] - 1] : -1;
        }
        
        return answer;
    }
}