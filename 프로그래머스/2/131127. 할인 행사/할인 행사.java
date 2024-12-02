import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int sum = 0;
        List<String> list;
        
        for (int n : number) {
            sum += n;
        }
        
        for (int i = 0; i <= discount.length - sum; i++) {
            list = new ArrayList<>();
            
            for (int j = 0; j < want.length; j++) {
                for (int k = 0; k < number[j]; k++) {
                    list.add(want[j]);
                }
            }
            
            for (int j = 0; j < sum && i + j < discount.length; j++) {
                if (!list.contains(discount[i + j])) {
                    break;
                }
                
                list.remove(discount[i + j]);
            }
            
            if (list.size() == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}