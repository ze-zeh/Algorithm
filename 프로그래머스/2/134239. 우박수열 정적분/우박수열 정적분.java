import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        double[] arr = makeArr(k);
        int n = arr.length;
        double[] width = new double[n];
        
        for (int i = 0; i < n - 1; i++) {
            width[i] = (arr[i] + arr[i + 1]) / 2;
        }
        
        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            int start = range[0];
            int end = range[1] > 0 ? range[1] : (n + range[1]);
            
            if (start >= end) {
                answer[i] = -1;
               continue;
            }
                
            for (int j = start; j < end - 1; j++) {
                answer[i] += width[j];
            }
        }
        
        return answer;
    }
    
    public double[] makeArr(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(k);
        
        while (k > 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            
            list.add(k);
        }
        
        double[] arr = new double[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        
        return arr;
    }
}