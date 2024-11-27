class Solution {
    static String[] Strings = {"A", "E", "I", "O", "U"};
    static int Answer = 0;
    static int Count = 0;
    
    public int solution(String word) {
        combination(word, "");
        
        return Answer;
    }
    
    public void combination(String word, String str) {
        if (str.length() > 5) {
            return;
        }
        
        if (word.equals(str)) {
            Answer = Count;
            return;
        }
        
        Count++;
        
        for (int i = 0; i < 5; i++) {
            combination(word, str + Strings[i]);
        }
    }
}