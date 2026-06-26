import java.util.*;

class Solution {
    public static final int P = 0;
    public static final int O = 1;
    public static final int X = 2;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int idx = 0;
        
        for (String[] place : places) {
            int isFine = 1;
            List<int[]> list = new ArrayList<>();
            int[][] map = new int[5][5];
            
            for (int i = 0; i < 5; i++) {
                String p = place[i];
                
                for (int j = 0; j < 5; j++) {
                    char ch = p.charAt(j);
                    
                    if (ch == 'P') {
                        map[i][j] = P;
                        list.add(new int[]{i, j});
                    } else if (ch == 'O') {
                        map[i][j] = O;
                    } else if (ch == 'X') {
                        map[i][j] = X;
                    }
                }
            }
            
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int[] a = list.get(i);
                    int[] b = list.get(j);
                    
                    boolean result = check(map, a, b);
                                        
                    if (!result) {
                        isFine = 0;
                        break;
                    }
                }
                
                if (isFine == 0) {
                    break;
                }
            }
            
            answer[idx++] = isFine;
        }
        
        return answer;
    }
    
    public boolean check(int[][] map, int[] a, int[] b) {
        boolean enable = true;
        int xDist = Math.abs(a[0] - b[0]);
        int yDist = Math.abs(a[1] - b[1]);
        int xMid = (a[0] + b[0]) / 2;
        int yMid = (a[1] + b[1]) / 2;
        
        if (xDist + yDist > 2) {
            return true;
        }
        
        if (xDist == 2 || yDist == 2) {
            enable = map[xMid][yMid] == X;
        } else if (xDist == 1 && yDist == 1) {
            enable = (map[a[0]][b[1]] == X) && map[b[0]][a[1]] == X;
        } else {
            enable = false;
        }
        
        return enable;
    }
}