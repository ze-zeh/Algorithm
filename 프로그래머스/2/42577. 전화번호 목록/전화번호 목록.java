import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> hs = new HashSet<>();
        
        Arrays.sort(phone_book, (o1, o2) -> o2.length() -o1.length());
        
        for (String str : phone_book) {
            if (hs.contains(str)) {
                return false;
            } else {
                StringBuilder sb = new StringBuilder(str);
                for (int i = str.length() - 1; i >= 1; i--) {
                    hs.add(str.substring(0, i));
                }
            }
        }
        
        return true;
    }
}