class Solution {
    static int Answer = 0;
    static boolean[] Visited;
    
    public int solution(int k, int[][] dungeons) {
        Visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        
        return Answer;
    }
    
    public void dfs(int k, int[][] dungeons, int depth) {
        for (int i = 0; i < dungeons.length; i++) {
            if (Visited[i] || k < dungeons[i][0]) {
                continue;
            }
            
            Visited[i] = true;
            dfs(k - dungeons[i][1], dungeons, depth + 1);
            Visited[i] = false;
        }
        
        Answer = Math.max(Answer, depth);
    }
}