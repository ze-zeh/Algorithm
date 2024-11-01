import java.util.*;

class Solution {
    public class Word {
        String str;
        int length;
        
        Word (String str, int length) {
            this.str = str;
            this.length = length;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(new Word(begin, 0));
        visited.add(begin);
        
        while (!queue.isEmpty()) {
            Word cur = queue.poll();
            
            if (cur.str.equals(target)) {
                return cur.length;
            }
            
            for (String word : words) {
                if (!visited.contains(word) && compareTwoWords(cur.str, word)) {
                    queue.add(new Word(word, cur.length + 1));
                    visited.add(word);
                }
            }
        }
        
        return 0;
    }
    
    public boolean compareTwoWords(String str1, String str2) {
        int count = 0;
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        
        if (count > 1) return false;
        
        return true;
    }
}