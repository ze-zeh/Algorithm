import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        
        for (int num : nums) {
            hs.add(num);
        }
        
        return Math.min(hs.size(), nums.length / 2);
    }
}