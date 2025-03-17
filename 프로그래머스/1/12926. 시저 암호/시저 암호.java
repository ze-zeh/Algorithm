class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch + n);
                
                if (ch > 'z') {
                    ch -= 'z' - 'a' + 1;
                }
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + n);
                
                if (ch > 'Z') {
                    ch -= 'Z' - 'A' + 1;
                }
            }
            
            answer += ch;
        }
        
        return answer;
    }
}