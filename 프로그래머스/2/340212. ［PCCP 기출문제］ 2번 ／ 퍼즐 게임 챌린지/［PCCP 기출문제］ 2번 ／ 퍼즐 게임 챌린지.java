import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = -1;
        
        for (int i = 0; i < times.length; i++) {
            end = Math.max(end, diffs[i]);
        }
        
        while (start < end) {
            int mid = (start + end) / 2;
            
            if (enable(mid, diffs, times, limit)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return end;
    }
    
    public boolean enable(int level, int[] diffs, int[] times, long limit) {
        long time = times[0];
        
        for (int i = 1 ; i < diffs.length; i++) {
            if (level >= diffs[i]) {
                time += times[i];
            } else {
                time += (diffs[i] - level) * (times[i] + times[i - 1]) + times[i];
            }
            
            if (limit < time) {
                return false;
            }
        }
        
        return true;
    }
}