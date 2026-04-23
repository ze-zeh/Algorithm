class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            int empty = (n / a) * b;
            answer += (n / a) * b;
            n %= a;
            n += empty;
        }
        
        return answer;
    }
}