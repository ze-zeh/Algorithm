class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = convert(n);
        
        for (int i = str.length() - 1; i >= 0; i--) {
            int cur = str.charAt(i) - '0';
            answer += cur * Math.pow(3, str.length() - 1 - i);
        }
        
        return answer;
    }
    
    public String convert(int n) {
        String result = "";
        
        while (n > 0) {
            result += n % 3;
            n /= 3;
        }
        
        return result;
    }
}