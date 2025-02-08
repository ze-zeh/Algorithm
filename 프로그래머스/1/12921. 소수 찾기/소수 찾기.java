class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] arr = new boolean[n + 1];
        
        for (int i = 2; i * i <= n; i++) {
            for (int j = 2; i * j <= n; j++) {
                arr[j * i] = true;
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (!arr[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}