class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] sum = new int[n + 1];
        int start = 0;
        int end = 1;
        
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + i;
        }
        
        while (end > start) {
            int diff = sum[end] - sum[start];
            
            if (diff == n) {
                answer++;
                start++;
            } else if (diff < n){
                if (end == n) {
                    start++;
                } else {
                    end++;
                }
            } else {
                start++;
            }
        }
        
        return answer;
    }
}
