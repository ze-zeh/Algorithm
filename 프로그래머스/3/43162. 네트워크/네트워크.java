import java.util.*;

class Solution {
    static Queue<Integer> Queue = new LinkedList<>();
    static boolean[] Visited;
    static int[][] Computers;
    static int N;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        Visited = new boolean[N];
        Computers = computers;
        
        for (int i = 0; i < N; i++) {
            if (!Visited[i]) {
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int n) {
        Queue.add(n);
        Visited[n] = true;
        
        while (!Queue.isEmpty()) {
            int cur = Queue.poll();
            
            for (int i = 0; i < N; i++) {
                if (i == cur || Visited[i] || Computers[cur][i] == 0) continue;
                
                Queue.add(i);
                Visited[i] = true;
            }
        }
    }
}