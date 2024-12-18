class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            answer[i] = s / n;
            
            if (i >= n - s % n) answer[i]++;
        }
        
        for (int i = 0; i < n; i++) {
            sum += answer[i];
        }
        
        if (sum != s || s / n == 0) {
            return new int[]{-1};
        }
        
        return answer;
    }
}