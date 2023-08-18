class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int dpMax = nums[0];
        int dpMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int prevMax = dpMax;
            int prevMin = dpMin;

            if (num >= 0) { // num이 양수인 경우
                dpMax = Math.max(prevMax * num, num);
                dpMin = Math.min(prevMin * num, num);
            } else { // num이 음수인 경우 -> 반대로 곱함
                dpMax = Math.max(prevMin * num, num);
                dpMin = Math.min(prevMax * num, num);
            }

            ans = Math.max(ans, dpMax);
        }

        return ans;
    }
}
