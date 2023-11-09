import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        int[] term = new int[26];
        StringTokenizer st = new StringTokenizer(today, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int date = Integer.parseInt(st.nextToken());
        
        for (String str : terms) {
            st = new StringTokenizer(str);
            term[st.nextToken().charAt(0) - 65] = Integer.parseInt(st.nextToken());    
        }
        
        for (int i = 1; i <= privacies.length; i++) {
            String privacy = privacies[i - 1];
            st = new StringTokenizer(privacy);
            
            String time = st.nextToken();
            int limit = term[st.nextToken().charAt(0) - 65];
            
            st = new StringTokenizer(time, ".");
            int pYear = Integer.parseInt(st.nextToken());
            int pMonth = Integer.parseInt(st.nextToken());
            int pDate = Integer.parseInt(st.nextToken());
            
            pYear += limit / 12;
            pMonth += limit % 12;

            if (pMonth > 12) {
                pMonth -= 12;
                pYear++;
            }
            
            System.out.println(limit + ": " + pYear + "." + pMonth + "." + pDate);
            
            if (year == pYear) {
                if (month == pMonth) {
                    if (date >= pDate) {
                        result.add(i);
                    }
                } else if (month > pMonth) {
                    result.add(i);
                }
            } else if (year > pYear) {
                result.add(i);
            }
        }
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}