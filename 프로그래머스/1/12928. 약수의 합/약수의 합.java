class Solution {
    public int solution(int n) {
        int answer = n;
        
        if (n == 0) return 0;
        
        for (int i = 1; i <= n /2; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        
        return answer;
    }
}