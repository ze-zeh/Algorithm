import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> Adj;
    static int N;
    
    public int solution(int n, int[][] edge) {
        int length = edge.length;
        Adj = new ArrayList<>();
        N = n;
        
        for(int i = 0 ; i <= N ; i++) {
            Adj.add(new ArrayList<>());
        }
        
        for (int[] i : edge) {
            int a = i[0];
			int b = i[1];
            
			Adj.get(a).add(b);
			Adj.get(b).add(a);
        }
        
        return bfs();
    }
    
    public int bfs() {
        int answer = 0;
        int maxDepth = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        
        queue.add(new int[]{1, 0});
        visited[1] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int depth = cur[1];
            
            if (maxDepth == depth) {
                answer++;
            } else if (maxDepth < depth) {
                maxDepth = depth;
                answer = 1;
            }
            
            for (int i = 0; i < Adj.get(node).size(); i++) {
				int next = Adj.get(node).get(i);
                
				if (!visited[next]) {
					queue.add(new int[] { next, depth + 1 });
					visited[next] = true;
				}
			}
        }
        
        return answer;
    }
}