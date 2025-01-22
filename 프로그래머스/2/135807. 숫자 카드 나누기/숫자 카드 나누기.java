import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int a = arrayA[0];
        int b = arrayB[0];
        
        for (int i = 1; i < arrayA.length; i++) {
            a = f(a, arrayA[i]);
        }
        
        for (int i = 1; i < arrayB.length; i++) {
            b = f(b, arrayB[i]);
        }
        
        for (int i = 0; i < arrayB.length; i++) {
            if (arrayB[i] % a == 0) {
                a = 0;
                break;
            }
        }
        
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] % b == 0) {
                b = 0;
                break;
            }
        }
        
        return Math.max(a, b);
    }
    
    public int f (int a, int b) {
        if (a % b == 0) {
            return b;
        }
        
        return f(b, a % b);
    }
}