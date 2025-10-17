class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (int i = 0; i <= d; i += k) {
            answer += (int) Math.sqrt(pow(d) - pow(i)) / k + 1;
        }
        
        return answer;
    }
    
    public long pow(long n) {
        return n * n;
    }
}