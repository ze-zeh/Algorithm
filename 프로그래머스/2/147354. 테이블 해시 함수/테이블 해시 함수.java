import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        final int c = col - 1;

        Arrays.sort(data, (o1, o2) -> o1[c] == o2[c] ? o2[0] - o1[0] : o1[c] - o2[c]);
        
        for (int i = row_begin; i <= row_end; i++) {
            int S = getS(data[i - 1], i);
            
            answer = S ^ answer;
        }
        
        return answer;
    }
    
    public int getS(int[] arr, int index) {
        int result = 0;
        
        for (int a : arr) {
            result += a % index;
        }
        
        return result;
    }
}