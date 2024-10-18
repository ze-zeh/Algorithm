import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int answer = 0;
        int idx = 0;
        int curWeight = 0;
        
        for (int i = 0; i < bridge_length; i++){
            bridge.add(0);
        }
        
        if (bridge_length == 1) return truck_weights.length + 1;
        if (truck_weights.length == 1) return bridge_length + 1;
        
        
        while (idx < truck_weights.length) {
            curWeight -= bridge.poll();
            answer++;
            
            if (curWeight + truck_weights[idx] <= weight) {
                bridge.add(truck_weights[idx]);
                curWeight += truck_weights[idx];
                idx++;
            } else {
                bridge.add(0);
            }
        }
        
        return answer + bridge_length;
    }
}