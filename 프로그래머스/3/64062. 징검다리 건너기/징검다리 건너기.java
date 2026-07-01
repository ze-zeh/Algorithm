class Solution {
    public static int[] Stones;
    public static int K;
    
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 0;
        int answer = 0;
        Stones = stones;
        K = k;

        for (int stone : Stones) {
            right = Math.max(right, stone);
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canCross(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
    
    public boolean canCross(int mid) {
        int count = 0;

        for (int stone : Stones) {
            if (stone < mid) {
                count++;
                                          
                if (count >= K) {
                    return false;
                }
            } else {
                count = 0;
            }
        }

        return true;
    }
}