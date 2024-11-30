import java.util.*;

class Solution {
    static int BinaryCount = 0;
    static int RemoveZeroCount = 0;
    
    public int[] solution(String s) {
        while (!s.equals("1")) {
            s = changeToBinary(removeZero(s).length());
        }
        
        return new int[]{BinaryCount, RemoveZeroCount};
    }
    
    public String removeZero(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                RemoveZeroCount++;
            } else {
                sb.append("1");
            }
        }
        
        return sb.toString();
    }
    
    public String changeToBinary(int number) {
        StringBuilder binary = new StringBuilder();
        
        while (number > 1) {
            binary.append(number % 2);
            number /= 2;
        }
        
        binary.append(1);
        BinaryCount++;
        
        return binary.reverse().toString();
    }
}