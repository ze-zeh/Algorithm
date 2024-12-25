class Solution {
    public String solution(int a, int b) {
        String[] answer = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = b;
        
        for (int i = 0; i < a - 1; i++) {
            day += days[i];
        }
        
        day %= 7;
                
        return answer[day];
    }
}