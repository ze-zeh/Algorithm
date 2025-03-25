class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] possible = {"aya", "ye", "woo", "ma"};
        String[] impossible = {"ayaaya", "yeye", "woowoo", "mama"};
        
        for (String b : babbling) {
            for (String i : impossible) b = b.replace(i, "X");
            for (String p : possible) b = b.replace(p, " ");
            b = b.replace(" ", "");
            
            if (b.equals("")) answer++;
        }
        
        return answer;
    }
}