class Solution {
    public int countSubstrings(String s) { // brute force로 그냥 다 돌았음
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int left = i;
                int right = j;

                while (s.charAt(left) == s.charAt(right)) {
                    if (left == right || left + 1 == right) {
                        count++;
                        break;
                    }

                    left++;
                    right--;
                }
            }
        }

        return count;
    }
}
