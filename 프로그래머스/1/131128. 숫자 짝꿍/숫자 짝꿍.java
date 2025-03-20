

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int[] x = new int[10];
        int[] y = new int[10];
        
        for (int i = 0; i < X.length(); i++) {
            x[X.charAt(i) - '0']++;
        }
        
        for (int i = 0; i < Y.length(); i++) {
            y[Y.charAt(i) - '0']++;
        }
        
        for (int i = 9; i >=0; i--) {
            int count = Math.min(x[i], y[i]);
            
            for (int j = 0; j < count; j++) {
                sb.append(i);
            }
        }
        
        if (sb.toString().equals("")) {
            answer = "-1";
        } else if (sb.charAt(0) == '0') {
            answer = "0";
        } else {
            answer = sb.toString();
        }
        
        return answer;
    }
}