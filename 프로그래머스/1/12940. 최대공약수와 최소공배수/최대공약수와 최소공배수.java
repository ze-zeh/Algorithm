class Solution {
    public int[] solution(int n, int m) {
        int g = (n > m) ? gcd(n, m) : gcd(m, n);
        int l = n * m / g;
        
        return new int[]{g, l};
    }
    
    public int gcd (int a, int b) {
        if (a % b == 0) {
            return b;
        }
            
        return gcd(b, a % b);
    }
}