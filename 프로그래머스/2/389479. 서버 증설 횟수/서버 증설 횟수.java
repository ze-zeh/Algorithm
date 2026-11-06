class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[24];
        
        for (int i = 0; i < 24; i++) {
            int player = players[i];
            
            if (player >= server[i] * m + m) {
                int p = player - server[i] * m;
                answer += p / m;
                
                for (int j = 0; j < k && i + j < 24; j++) {
                    server[i + j] += p / m;
                }
            }
        }
        
        return answer;
    }
}