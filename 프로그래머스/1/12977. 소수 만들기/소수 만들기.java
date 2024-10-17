import java.util.*;

public class Solution {
    public int solution(int[] nums) {
        return combination(nums, 0, 0, 0);
    }
    
    public int combination(int[] nums, int start, int count, int sum) {
        if (count == 3) {
            if (isPrime(sum)) {
                return 1;
            } else {
                return 0;
            }
        }

        int result = 0;
        
        for (int i = start; i < nums.length; i++) {
            result += combination(nums, i + 1, count + 1, sum + nums[i]);  
        }

        return result;
    }

    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
