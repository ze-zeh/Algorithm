class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int current = 1;

        for (int i = 0; i < section.length; i++) {
            if (current <= section[i]) {
                current = section[i] + m;
                answer++;
            }
        }

        return answer;
    }
}