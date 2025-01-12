import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> hm = new HashMap<>();

        Arrays.sort(weights);
        
        for (int weight : weights) {
            double a = weight * 1.0;
            double b = (weight * 2.0) / 3.0;
            double c = (weight * 1.0) / 2.0;
            double d = (weight * 3.0) / 4.0;

            if (hm.containsKey(a)) answer += hm.get(a);
            if (hm.containsKey(b)) answer += hm.get(b);
            if (hm.containsKey(c)) answer += hm.get(c);
            if (hm.containsKey(d)) answer += hm.get(d);

            hm.put((weight * 1.0), hm.getOrDefault((weight * 1.0), 0) + 1);
        }
        
        return answer;
    }
}