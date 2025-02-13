import java.util.*;

class Solution {
    public long solution(long n) {
        long x = (long)Math.sqrt(n);
        
        if (x * x == n) {
            return (x + 1) * (x + 1);
        }
    
        return -1;
    }
}