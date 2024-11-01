import java.util.*;

class Solution {
    static ArrayList<String> Answer = new ArrayList<>();
    static boolean[] Visited;
    
    public String[] solution(String[][] tickets) {
        Visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(Answer);
        
        return Answer.get(0).split(" ");
    }
    
    public void dfs(String start, String route, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            Answer.add(route);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!tickets[i][0].equals(start) || Visited[i]) continue;
            
            Visited[i] = true;
            dfs(tickets[i][1], route + " " + tickets[i][1], tickets, depth + 1);
            Visited[i] = false;
        }
    }
}