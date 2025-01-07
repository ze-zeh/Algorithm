class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int cur = storey % 10;
            storey /= 10;

            if (cur > 5 || (cur == 5 && storey % 10 >= 5)) {
                answer += 10 - cur;
                storey++;
            } else {
                answer += cur;
            }
        }
        
        return answer;
    }
}