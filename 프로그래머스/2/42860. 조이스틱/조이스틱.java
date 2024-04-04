class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int move = n - 1;
        
        for (int i = 0; i < n; i++) {
            int index = i + 1;
            
            while (index < n && name.charAt(index) == 'A'){
                index++;
            }
            
            move = Math.min(move, i * 2 + (n - index));
            move = Math.min(move, (n - index) * 2 + i);
            
            answer += Math.min('Z' - name.charAt(i) + 1, name.charAt(i) - 'A');
        }
        
        return answer + move;
    }
}