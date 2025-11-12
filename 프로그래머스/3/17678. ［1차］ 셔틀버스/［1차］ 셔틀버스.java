import java.util.*;

class Solution {
    final static int SIXTY = 60;
    
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st;
        int last = 9 * SIXTY + (n - 1) * t;
        int remain = m;
        
        for (String time : timetable) {
            st = new StringTokenizer(time, ":");
            
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());
            
            pq.add(hour * SIXTY + minute);
        }
        
        for (int i = 0; i < n; i++) {
            int time = 9 * SIXTY + i * t;
            remain = m;
            
            if (pq.isEmpty()) {
                break;
            }
            
            if (pq.peek() > time) {
                last = time;
                continue;
            }
            
            for (int j = 0; j < m; j++) {
                if (pq.isEmpty()) {
                    last = 9 * SIXTY + (n - 1) * t;
                    break;
                }
                
                if (pq.peek() <= time) {
                    last = pq.poll();
                    remain = m - j - 1;
                }
            }
        }
        
        if ((!pq.isEmpty() && pq.peek() == last) || remain == 0) {
            last--;
        }
        
        return intToString(last);
    }
    
    public String intToString(int time) {
        int hour = time / SIXTY;
        int minute = time % SIXTY;
        String result = "";
        
        if (hour < 10) {
            result += "0";
        }
        
        result += hour +":";
        
        if (minute < 10) {
            result += "0";
        }
        
        result += minute;
        
        return result;
    }
}