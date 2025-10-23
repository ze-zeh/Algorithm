class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            int num = arr1[i] | arr2[i];
            answer[i] = intToCode(num, n);
        }
        
        return answer;
    }
    
    public String intToCode(int num, int n) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            result.append(num % 2 == 1 ? "#" : " ");
            num /= 2;
        }
        
        return result.reverse().toString();
    }
}