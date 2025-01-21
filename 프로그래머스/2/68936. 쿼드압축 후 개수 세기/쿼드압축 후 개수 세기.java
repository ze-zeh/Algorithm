class Solution {
    static int Zero = 0;
    static int One = 0;
    
    public int[] solution(int[][] arr) {
        compress(arr);
        return new int[] {Zero, One};
    }
    
    public void compress(int[][] arr) {
        int n = arr.length;
        
        if (n == 1) {
            if (arr[0][0] == 1) {
                One++;
            } else {
                Zero++;
            }
            
            return;
        }
        
        if (checkAllSame(arr)) {
            return;
        }
        
        int[] dX = {0, n / 2, 0, n / 2};
        int[] dY = {0, 0, n / 2, n / 2};
        
        for (int h = 0; h < 4; h++) {
            int[][] newArr = new int[n / 2][n / 2];
                
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    newArr[i][j] = arr[dX[h] + i][dY[h] + j];
                }
            }
            
            compress(newArr);
        }
    }
    
    public boolean checkAllSame(int[][] arr) {
        int n = arr.length;
        boolean flag = true;
        int num = arr[0][0];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != num) {
                    flag = false;
                    break;
                }
            }
        }
        
        if (flag) {
            if (arr[0][0] == 1) {
                One++;
            } else {
                Zero++;
            }
            
            return true;
        }
        
        return false;
    }
}