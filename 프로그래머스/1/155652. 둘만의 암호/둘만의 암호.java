class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder("");
        boolean[] isSkipped = new boolean[26];
        
        for (int i = 0; i < skip.length(); i++) {
            isSkipped[skip.charAt(i) - 'a'] = true;
        }
        
        for (int i = 0; i < s.length(); i++) {
            int start = s.charAt(i) - 'a';
            int end = start;
            int count = 0;
            
            while (count != index) {
                end = (end + 1) % 26;
                
                if (!isSkipped[end]) count++;
            }
            
            answer.append((char)('a' + end));
        }
        
        return answer.toString();
    }
}