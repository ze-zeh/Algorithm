class Solution {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        
        s = s.toLowerCase();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == 'p') {
                p++;
            } else if (ch == 'y') {
                y++;
            }
        }

        return p == y;
    }
}