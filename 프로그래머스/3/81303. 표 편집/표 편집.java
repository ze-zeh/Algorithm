import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int idx = k; // 선택된 인덱스
        int size = n; // 현재 표 크기
        
        for (String str : cmd) {
            char action = str.charAt(0);
            
            switch (action) {
                case 'U' : {
                    idx -= Integer.parseInt(str.substring(2));
                    
                    break;
                }
                    
                case 'D' : {
                    idx += Integer.parseInt(str.substring(2));
                    
                    break;
                }
                    
                case 'C' : {
                    stack.push(idx);
                    size--;
                    
                    if (size == idx) idx--; // 마지막 인덱스가 지워진 경우
                    
                    break;
                }
                    
                case 'Z' : {
                    size++;
                    if (stack.pop() <= idx) idx++; // 현재 인덱스보다 앞에서 복구된 경우
                    
                    break;
                }
            }
        }
        
        for (int i = 0 ; i < size; i++) {
            answer.append("O");
        }
        
        while (!stack.isEmpty()) {
            answer.insert(stack.pop(), "X");
        }
        
        return answer.toString();
    }
    
    
}