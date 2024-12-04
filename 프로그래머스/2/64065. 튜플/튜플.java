import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        s = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] arr = s.split("-");
        Set<Integer> hs = new HashSet<>();
        
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        
        for (String a : arr) {
            String[] nums = a.split(",");
            
            for (String num : nums) {
                int n = Integer.parseInt(num);
                
                if (!hs.contains(n)) {
                    hs.add(n);
                    answer.add(n);
                }
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}