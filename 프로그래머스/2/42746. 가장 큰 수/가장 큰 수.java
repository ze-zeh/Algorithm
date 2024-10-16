import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] strings = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = numbers[i] + "";
        }
        
        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (strings[0].equals("0")) {
           return "0";
        }
        
        for (int i = 0; i < strings.length; i++) {
            answer.append(strings[i]);
        }
        
        return answer.toString();
    }
}