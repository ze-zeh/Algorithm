class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for (int i = 0; i <= t.length() - p.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                int diff = t.charAt(i + j) - p.charAt(j);
                
                if (diff < 0) {
                    answer++;
                    break;
                } else if (diff > 0) {
                    break;
                } else {
                    if (j == p.length() - 1) answer++;
                }
            }
        }
        
        return answer;
    }
}