class Solution {
    public int[] solution(int n, long left, long right) {
        int diff = (int) (right - left);
        int[] answer = new int[diff + 1];
        
        for (int i = 0; i <= diff; i++) {
            int x = (int) ((left + i) / ((long) n));
            int y = (int) ((left + i) % ((long) n));
            
            answer[i] = Math.max(x, y) + 1;
        }
        
        return answer;
    }
}