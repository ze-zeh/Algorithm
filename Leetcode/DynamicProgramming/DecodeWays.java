class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        if (n == 0) return 0;

        dp[n] = 1;

        if (s.charAt(n - 1) == '0') { // 끝이 0이면 앞이 1또는 2여야 하므로
            dp[n - 1] = 0;
        } else {
            dp[n - 1] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue; // 0이면 이전 index로 넘어감

            if (Integer.parseInt(s.substring(i, i + 2)) <= 26) { // 현재 index와 다음 index 숫자가 26보다 작은 경우 -> 숫자가 이어짐
                dp[i] = dp[i + 1] + dp[i + 2];
            } else { // 이전 숫자와 안이어짐 => 이래야 해독 불가 시 0으로 끝남
                dp[i] = dp[i + 1];
            }
        }

        return dp[0];
    }
}
