class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 0;
        String result = "";
        boolean[][] dp = new boolean[n][n];

        for (int left = n - 1; left >= 0; left--) {
            for (int right = left; right < n; right++) {
                if (s.charAt(left) == s.charAt(right)) {
                    if (right - left <= 2) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }

                if (dp[left][right] && maxLength < right - left + 1) {
                    maxLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
            }
        }

        return result;
    }
}
