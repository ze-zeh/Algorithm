class Solution {
    static int M, N;
    static int sx, sy;
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int size = balls.length;
        int[] answer = new int[size];
        M = m;
        N = n;
        sx = startX;
        sy = startY;
        
        for (int i = 0; i < size; i++) {
            answer[i] = getMinDistance(balls[i][0], balls[i][1]);
        }
        
        return answer;
    }
    
    public int getMinDistance(int bx, int by) {
        int a, b;
        
        if (sx == bx) {    
            int x = Math.abs(by - sy);
            int y = Math.min(bx, M - bx) * 2;
            
            a = getDist(x, y);
            
            if (sy < by) {
                b = pow(sy + by);
            } else {
                b = pow(N * 2 - sy - by);
            }
        } else if (sy == by) {
            int x = Math.abs(bx - sx);
            int y = Math.min(by, N - by) * 2;
            
            a = getDist(x, y);
            
            if (sx < bx) {
                b = pow(sx + bx);
            } else {
                b = pow(M * 2 - sx - bx);
            }
        } else {
            int x1 = Math.abs(bx - sx);
            int y1 = Math.min(by + sy, N * 2 - by - sy);
            
            int x2 = Math.abs(by - sy);
            int y2 = Math.min(bx + sx, M * 2 - bx - sx);
            
            a = getDist(x1, y1);
            b = getDist(x2, y2);
        }
        
        return Math.min(a, b);
    }
    
    public int getDist(int x, int y) {
        return x * x + y * y;
    }
    
    public int pow(int x) {
        return x * x;
    }
}