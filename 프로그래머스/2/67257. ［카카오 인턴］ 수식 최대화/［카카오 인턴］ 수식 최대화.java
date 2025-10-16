import java.util.*;

class Solution {
    static boolean[] Visited;
    static int[] Priority;
    static long Answer;
    static String Expression;
    static List<String> List;
    
    public long solution(String expression) {
        Answer = 0;
        Visited = new boolean[3];
        Priority = new int[3];
        List = new ArrayList<>();
        Expression = expression;
        
        extract();
        perm(0);
        
        return Answer;
    }
    
    public void perm(int n) {
        if (n == 3) {
            getSum();
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (Visited[i]) {
                continue;
            }
            
            Visited[i] = true;
            Priority[n] = i;
            perm(n + 1);
            Visited[i] = false;
        }
    }
    
    public void extract() {
        String exp = Expression;
        String num = "";
        
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            
            if (ch == '*' || ch == '-' || ch == '+') {
                List.add(num);
                List.add(ch + "");
                num = "";
            } else {
                num += ch;
            }
        }
        
        List.add(num);
    }
    
    public void getSum() {
        String[] symbols = {"+", "-", "*"};
        List<String> list = new ArrayList<>(List);
        
        for (int i = 0; i < 3; i++) {
            int size = list.size();
            
            for (int j = 0; j < size; j++) {
                String symbol = symbols[Priority[i]];
                
                if (list.get(j).equals(symbol)) {
                    long a = Long.parseLong(list.get(j - 1));
                    long b = Long.parseLong(list.get(j + 1));
                    
                    if (symbol.equals("+")) {
                        list.set(j - 1, a + b + "");
                    } else if (symbol.equals("-")) {
                        list.set(j - 1, a - b + "");
                    } else {
                        list.set(j - 1, a * b + "");
                    }
                    
                    list.remove(j + 1);
                    list.remove(j);
                    
                    j--;
                    size -= 2;
                }
            }
        }
        
        Answer = Math.max(Answer, Math.abs(Long.parseLong(list.get(0))));
    }
}