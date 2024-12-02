class Solution {
    public int solution(int n, int a, int b) {
        int k = n;
        int s = 0;
        a--;
        b--;
        
        while (k > 1) {
            k >>= 1;
            s++;
        }
        
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < n; j += (2 << i)) {
                if (a >= j && b >= j && a < j + (2 << i) && b < j + (2 << i) ) {
                    return i + 1;
                }
            }
        }

        return -1;
    }
}

