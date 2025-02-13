class Solution {
    public long solution(long n) {
        String answer = "";
        String str = String.valueOf(n);
        int[] arr = new int[10];
        
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - '0']++;
        }
        
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < arr[i]; j++) {
                answer += i;
            }
        }
        
        return Long.parseLong(answer);
    }
}