import java.util.*;

class Solution {
    public long[] solution(int[][] program) {
        long[] answer = new long[11];
        // 점수 -> 호출시각 순서로 정렬
        PriorityQueue<int[]> waitHeap = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        // 호출시각 순서로 정렬
        PriorityQueue<int[]> sleepHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        long time = -1;
        int run = 0;
        
        for (int[] p : program) {
            sleepHeap.add(p);
        }
        
        while (!waitHeap.isEmpty() || !sleepHeap.isEmpty() || run != 0) {
            time++;
            
            // 실행 중 이라면 감소, 즉 0이라면 실행 중 아님.
            if (run > 0) run--;
            
            // 호출
            // 시간이 같다면, 슬립 힙에서 꺼내서 웨잇 힙에 추가
            while (!sleepHeap.isEmpty() && sleepHeap.peek()[1] == time) {
                waitHeap.add(sleepHeap.poll());
            }
            
            // 실행
            if (run == 0 && !waitHeap.isEmpty()) {
                int[] curProgram = waitHeap.poll();
                // 실행시간에 추가
                run += curProgram[2];
                // 정답에는 실행된 시각 - 대기열에 들어간 시각이 기록됩니다.
                // 주의할 점은 프로그램 별로 저장되는게 아니라 우선순위 별로 기록된다는 것 입니다.
                // ex) 우선순위가 1인 프로그램은 answer[1]에 저장됨.
                answer[curProgram[0]] += time - curProgram[1];
            }
        }
        
        answer[0] = time;
        
        return answer;
    }
}