import java.util.*;

class Solution {
    static int[] Degree;
    static List<List<Integer>> Adj;
    static boolean[] Visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        Adj = new ArrayList<>();
        Degree = new int[n];
        Visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            Adj.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            Adj.get(wire[0] - 1).add(wire[1] - 1);
            Adj.get(wire[1] - 1).add(wire[0] - 1);
        }
        
        Visited[0] = true;
        dfs(0);
        
        for (int i = 1; i < n; i++) {
            answer = Math.min(answer, Math.abs(n - 2 * Degree[i]));
        }
        
        return answer;
    }
    
    public int dfs(int n) {
        int count = 1;
        
        for (int i : Adj.get(n)) {
            if (Visited[i]) continue;
            Visited[i] = true;
            count += dfs(i);
        }
        
        Degree[n] = count;
        
        return count;
    }
}