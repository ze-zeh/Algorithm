import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringTokenizer st = new StringTokenizer(numToString(n, k), "0");

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            
            if (!token.isEmpty()) {
                long num = Long.parseLong(token);
                
                if (isPrimeNum(num)) {
                    answer++;
                }
            }
        }
        
        return answer;
    }

    public String numToString(int n, int k) {
        return Integer.toString(n, k);
    }

    public boolean isPrimeNum(long n) {
        if (n <= 1) {
            return false;
        }

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
