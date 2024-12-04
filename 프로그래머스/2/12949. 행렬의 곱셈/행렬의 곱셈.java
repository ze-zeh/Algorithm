class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int l = arr2.length;
        int m = arr1.length;
        int n = arr2[0].length;
        int[][] answer = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                
                for (int k = 0; k < l; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                
                answer[i][j] = sum;
            }
        }
        
        return answer;
    }
}