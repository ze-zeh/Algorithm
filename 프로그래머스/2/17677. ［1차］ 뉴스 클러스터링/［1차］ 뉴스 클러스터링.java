import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> list1 = stringToList(str1);
        List<String> list2 = stringToList(str2);
        List<String> union = new ArrayList<>();
        List<String> inter = new ArrayList<>();
        
        if (list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }
        
        for (String s : list1) {
            if (list2.contains(s)) {
                list2.remove(s);
                inter.add(s);
            }

            union.add(s);
        }
        
        union.addAll(list2);
        
        return (int) ((double) inter.size() / (double) union.size() * 65536);
    }
    
    private List<String> stringToList(String str) {
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < str.length() - 1; i++) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i + 1);
            
            if (!checkAlphabet(ch1) || !checkAlphabet(ch2)) {
                continue;
            }
            
            list.add(("" + ch1 + ch2).toUpperCase());
        }
        
        return list;
    }
    
    public boolean checkAlphabet(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }
}