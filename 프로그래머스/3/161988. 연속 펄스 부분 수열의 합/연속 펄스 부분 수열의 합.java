class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[] prefix = new long[n + 1];
        long min = 0;
        long max = 0;
        
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + sequence[i - 1] * (i % 2 == 0 ? 1 : -1);
            min = Math.min(min, prefix[i]);
            max = Math.max(max, prefix[i]);
        }
        
        return max - min;
    }
}