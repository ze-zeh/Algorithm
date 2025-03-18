class Solution {
    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();
        boolean[][] block = new boolean[h][w];
        int[] dx = {-1 , 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'X') {
                    block[i][j] = true;
                } else if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        
        for (String route : routes) {
            String[] s = route.split(" ");
            String dir = s[0];
            int dist = Integer.parseInt(s[1]);
            int idx;
            int nx = x;
            int ny = y;
            boolean isBlocked = false;
            
            if (dir.equals("N")) {
                idx = 0;
            } else if (dir.equals("E")) {
                idx = 1;
            } else if (dir.equals("S")) {
                idx = 2;
            } else if (dir.equals("W")) {
                idx = 3;
            } else {
                idx = -1;
            }
            
            for (int i = 0; i < dist; i++) {
                nx += dx[idx];
                ny += dy[idx];
                
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || block[nx][ny]) {
                    isBlocked = true;
                    break;
                }
            }
            
            if (isBlocked) {
                continue;
            }
            
            x = nx;
            y = ny;
        }
        
        return new int[]{x, y};
    }
}