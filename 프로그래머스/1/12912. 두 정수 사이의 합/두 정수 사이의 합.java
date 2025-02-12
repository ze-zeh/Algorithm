import java.util.*;

class Solution {
    public long solution(int a, int b) {
        return (long) (b + a) * (Math.abs(b - a) + 1) / 2;
    }
}