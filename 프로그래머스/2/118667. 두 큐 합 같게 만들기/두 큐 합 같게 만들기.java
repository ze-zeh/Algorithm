import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        long a = 0;
        long b = 0;
        int i = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int n1 : queue1) {
            q1.add(n1);
            a += n1;
        }
        
        for (int n2 : queue2) {
            q2.add(n2);
            b += n2;
        }
        
        while (a != b && i <= (queue1.length + queue2.length) * 2) {
            if (a > b) {
                int k = q1.poll();
                
                q2.add(k);
                a -= k;
                b += k;
            } else {
                int k = q2.poll();
                
                q1.add(k);
                a += k;
                b -= k;
            }
            
            i++;
        }
        
        if (a == b) {
            answer = i;
        }
        
        return answer;
    }
}