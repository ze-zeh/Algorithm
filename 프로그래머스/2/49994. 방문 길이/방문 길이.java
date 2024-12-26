import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> hs = new HashSet<>();
        int[] dx = {0, 1, 0, -1}; // U R D L
        int[] dy = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            int idx = 0;
            
            if (ch == 'U') {
                idx = 0;
            } else if (ch == 'R') {
                idx = 1;
            } else if (ch == 'D') {
                idx = 2;
            } else if (ch == 'L') {
                idx = 3;
            }
            
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            
            if (nx > 5) {
                nx = 5;
            } else if (nx < -5) {
                nx = -5;
            }
            
            if (ny > 5) {
                ny = 5;
            } else if (ny < -5) {
                ny = -5;
            }
            
            if (x != nx || y != ny) {
                hs.add(x + " " + y + " " + nx + " " + ny);
                hs.add(nx + " " + ny + " " + x + " " + y);
            }
            
            x = nx;
            y = ny;
        }
        
        return hs.size() / 2;
    }
}