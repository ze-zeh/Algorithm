import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, int[]> parkingLot = new HashMap<>();
        Map<Integer, Integer> totalTime = new HashMap<>();
        
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            int time = convertTime(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            boolean isIn = st.nextToken().equals("IN");
            
            if (isIn) {
                parkingLot.put(number, new int[]{time, convertTime("23:59")});
            } else {
                int t = time - parkingLot.remove(number)[0];
                totalTime.put(number, totalTime.getOrDefault(number, 0) + t);
            }
        }
        
        for (int key : parkingLot.keySet()) {
            int[] arr = parkingLot.get(key);
            int t = arr[1] - arr[0];
            totalTime.put(key, totalTime.getOrDefault(key, 0) + t);
        }
        
        int[] keys = totalTime.keySet().stream().mapToInt(i -> i).toArray();
        int[] answer = new int[keys.length];
        
        Arrays.sort(keys);
        
        for (int i = 0; i < keys.length; i++) {
            int time = totalTime.get(keys[i]);
            
            answer[i] = calcFee(time, fees);
        }
        
        return answer;
    }
    
    public int convertTime(String time) {
        String[] s = time.split(":");
        
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
    
    public int calcFee(int time, int[] fees) {
        return fees[1] + (int) Math.ceil(Math.max(0, time - fees[0]) / (double) fees[2]) * fees[3];
    }
}