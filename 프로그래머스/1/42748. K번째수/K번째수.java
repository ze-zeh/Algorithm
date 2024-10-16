import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int count = 0;
        
        for (int[] command : commands) {
            int arrSize = command[1] - command[0] + 1;
            int[] newArr = new int[arrSize];
            
            for (int i = command[0] - 1; i <= command[1] - 1; i++) {
                newArr[i - command[0] + 1] = array[i];
            }
                        
            Arrays.sort(newArr);
            answer[count++] = newArr[command[2] - 1];
        }
        
        return answer;
    }
}