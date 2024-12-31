class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];
        int n = sequence.length;

        while (start < n && end < n) {
            if (sum < k) {
                if (++end < n) {
                    sum += sequence[end];
                }
            } else if (sum > k) {
                sum -= sequence[start++];
            } else {
                if (minLength > end - start) {
                    minLength = end - start;
                    answer[0] = start;
                    answer[1] = end;
                }
                sum -= sequence[start++];
            }
        }

        return answer;
    }
}