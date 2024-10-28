import java.util.*;

class Solution {
    public static Set<Integer> Hs = new HashSet<>();;
    
    public int solution(String numbers) {
        int answer = 0;
        
        recursive("", numbers);
        
        for (int num : Hs) {
            if (isPrime(num)) {
                answer++;
            }
        }
    
        return answer;
    }
    
    public boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        
        int limit = (int) Math.sqrt(num);
        
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public void recursive(String str, String numbers) {
        if (!str.equals("")) {
            Hs.add(Integer.parseInt(str));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            recursive(str + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1));
        }
    }
}