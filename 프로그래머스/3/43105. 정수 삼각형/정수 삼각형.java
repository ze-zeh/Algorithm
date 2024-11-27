class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);
            }
        }
        
        return triangle[0][0];
    }
}