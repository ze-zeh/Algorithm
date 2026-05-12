class Solution {
    static int[][][] timeline;
    static int x;
    static int r, c;
    static int max;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public int solution(int[][] points, int[][] routes) {
        x = routes.length;
        r = 0;
        c = 0;
        max = 0;
        
        for (int[] point : points) {
            r = Math.max(r, point[0]);
            c = Math.max(c, point[1]);
            
            point[0]--;
            point[1]--;
        }
        
        for (int[] route : routes) {
            int length = 0;
            
            for (int i = 1; i < route.length; i++) {
                length += getDist(points[route[i - 1] - 1], points[route[i] - 1]);
            }
            
            max = Math.max(max, length);
        }
        
        max++;
        
        timeline = new int[x][max][2];
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < max; j++) {
                timeline[i][j][0] = -1;
                timeline[i][j][1] = -1;
            }
        }
        
        for (int i = 0 ; i < x; i++) {
            int time = 0;
            int[] route = routes[i];
            int[] start = points[route[0] - 1];
            
            for (int j = 1; j < route.length; j++) {
                int[] end = points[route[j] - 1];
                
                dfs(start, end, i, time);
                
                time += getDist(start, end);
                start = end;
            }
        }
        
        return getAnswer();
    }
    
    public void dfs(int[] start, int[] end, int idx, int time) {
        if (start[0] == end[0] && start[1] == end[1]) {
            timeline[idx][time][0] = end[0];
            timeline[idx][time][1] = end[1];
            return;
        }
        
        timeline[idx][time][0] = start[0];
        timeline[idx][time][1] = start[1];
        
        int dir = getDir(start, end);
        int[] newStart = new int[] {start[0] + dx[dir], start[1] + dy[dir]};
        
        dfs(newStart, end, idx, time + 1);
    }
    
    public int getDir(int[] start, int[] end) {
        if (start[0] > end[0]) {
            return 0;
        } else if (start[0] < end[0]) {
            return 2;
        } else {
            if (start[1] > end[1]) {
                return 1;
            } else if (start[1] < end[1]) {
                return 3;
            }
        }
        
        return 0;
    }
    
    public int getDist(int[] start, int[] end) {
        return Math.abs(end[0] - start[0]) + Math.abs(end[1] - start[1]);
    }
    
    public int getAnswer() {
        int answer = 0;
        
        for (int j = 0; j < max; j++) {
            int[][] count = new int[r][c];
            
            for (int i = 0; i < x; i++) {
                int a = timeline[i][j][0];
                int b = timeline[i][j][1];
                
                if (a >= 0 && b >= 0) {
                    count[a][b]++;
                }
            }
            
            for (int s = 0; s < r; s++) {
                for (int t = 0; t < c; t++) {
                    if (count[s][t] >= 2) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}