class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] walls = new boolean[n];
        
        for (int s : section) {
            walls[s - 1] = true;
        }
        
        for (int i = 0; i < n; i++) {
            if (walls[i]) {
                answer++;
                
                for (int j = 0; j < m && i + j < n; j++) {
                    walls[i + j] = false;
                }
            }
        }
         
        return answer;
    }
}