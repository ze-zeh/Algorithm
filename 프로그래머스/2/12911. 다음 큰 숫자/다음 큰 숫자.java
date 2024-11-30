import java.util.*;

class Solution {
    public int solution(int n) {
        int a = countOne(changeToBinary(n));
        
        while (true) {
            int b = countOne(changeToBinary(++n));
            
            if (a == b) {
                return n;
            }
        }
    }
    
    public String changeToBinary(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 1) {
            sb.append(n % 2);
            n /= 2;
        }
        
        return sb.reverse().toString();
    }
    
    public int countOne(String binary) {
        int count = 0;
        
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }
        
        return count;
    }
}