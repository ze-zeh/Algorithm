import java.util.*;

class Solution {
    public class File implements Comparable<File> {
        String name;
        String head;
        int number;
        int order;
        
        File (String name, int order) {
            this.name = name;
            this.head = nameToHead(name);
            this.number = nameToNumber(name);
            this.order = order;
        }
        
        @Override
        public int compareTo(File f) {
            if (!this.head.equals(f.head)) {
                return this.head.compareTo(f.head);
            }
            
            if (this.number != f.number) {
                return this.number - f.number;
            }
            
            return this.order - f.order;
        }
        
        private String nameToHead(String name) {
            for (int i = 0; i < name.length(); i++) {
                if (Character.isDigit(name.charAt(i))) {
                    return name.substring(0, i).toLowerCase();
                }
            }
            
            return "";
        }
        
        private int nameToNumber(String name) {
            int start = 0;
            int end = 0;
            
            for (int i = 0; i < name.length(); i++) {                
                if (Character.isDigit(name.charAt(i))) {
                    start = i;
                    end = start;
                    
                    while (end < name.length()
                            && Character.isDigit(name.charAt(end))
                            && end - start < 5) {
                        end++;
                    }
                    
                    break;
                }
            }
            
            return Integer.parseInt(name.substring(start, end));
        }
    }
    
    public String[] solution(String[] files) {
        File[] fs = new File[files.length];
        
        for (int i = 0; i < files.length; i++) {
            fs[i] = new File(files[i], i);
        }
        
        Arrays.sort(fs);
        
        for (int i = 0; i < files.length; i++) {
            files[i] = fs[i].name;
        }
        
        return files;
    }
}