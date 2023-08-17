class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) { //  j < i
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);

                if (wordDict.contains(sub) && (j == 0 || dp[j - 1])) { // (sub가 포함될 때) + (j 인덱스가 0 or j 이전까지 참)
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }
}
