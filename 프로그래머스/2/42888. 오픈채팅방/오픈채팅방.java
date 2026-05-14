import java.util.*;

class Solution {
    static final String ENTER_MSG = "님이 들어왔습니다.";
    static final String LEAVE_MSG = "님이 나갔습니다.";
        
    public String[] solution(String[] record) {
        String[] answer;
        StringTokenizer st;
        HashMap<String, String> hm = new HashMap<>();
        List<String[]> list = new ArrayList<>();
        
        for (String r : record) {
            st = new StringTokenizer(r);
            String command = st.nextToken();
            String id = st.nextToken();
            
            if (command.equals("Enter")) {
                String nickname = st.nextToken();
                hm.put(id, nickname);
                list.add(new String[] {id, command});
            } else if (command.equals("Leave")) {
                list.add(new String[] {id, command});
            } else if (command.equals("Change")) {
                String nickname = st.nextToken();
                hm.put(id, nickname);
            }
        }
        
        answer = new String[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = hm.get(list.get(i)[0]);
            
            if (list.get(i)[1].equals("Leave") ) {
                answer[i] += LEAVE_MSG;
            } else {
                answer[i] += ENTER_MSG;
            }
        }
        
        return answer;
    }
}