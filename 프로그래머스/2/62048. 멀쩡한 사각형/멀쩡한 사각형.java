class Solution {
    public long solution(int w, int h) {
        long answer = (long) w * h;
        int lgd = w > h ? lgd(w, h) : lgd(h, w);
        int a = w / lgd;
        int b = h / lgd;
        
        answer -= (a + b - 1) * lgd;
        
        return answer;
    }
    
    public int lgd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return lgd(b, a % b);
    }
}