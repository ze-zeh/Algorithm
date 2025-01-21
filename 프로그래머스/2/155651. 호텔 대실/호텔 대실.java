import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] bookTime = new int[book_time.length][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        for (int i = 0; i < book_time.length; i++) {
            bookTime[i][0] = convertTime(book_time[i][0]);
            bookTime[i][1] = convertTime(book_time[i][1]) + 10;
        }
        
        Arrays.sort(bookTime, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        
        for (int[] book : bookTime) {
            if (!pq.isEmpty()) {
                if (book[0] >= pq.peek()[1]) {
                    pq.poll();
                }
            }
            
            pq.add(book);
        }
        
        return pq.size();
    }
    
    public int convertTime(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        
        return hour * 60 + minute;
    }
}