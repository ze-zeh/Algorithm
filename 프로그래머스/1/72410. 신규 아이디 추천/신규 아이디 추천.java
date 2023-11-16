import java.util.*;

class Solution {
    public String solution(String new_id) {
        new_id = first(new_id);
        new_id = second(new_id);
        new_id = third(new_id);
        new_id = fourth(new_id);
        new_id = fifth(new_id);
        new_id = sixth(new_id);
        new_id = seventh(new_id);
        
        return new_id;
    }
    
    public String first(String new_id) {
        return new_id.toLowerCase();
    }
    
    public String second(String new_id) {
        StringBuilder result = new StringBuilder("");
        
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
                        
            if ((ch >= 97 && ch <= 122) || (ch >= '0' && ch <= '9') || ch == '-' || ch == '_' || ch == '.') {
                result.append(ch);
            }
        }
                
        return result.toString();
    }
    
    public String third(String new_id) {
        int length = new_id.length();
        
        while (true) {
            new_id = new_id.replace("..", ".");
            
            if (length == new_id.length()) {
                break;
            }
            
            length = new_id.length();
        }
        
        return new_id;
    }
    
    public String fourth(String new_id) {
        if (new_id.length() == 1) {
            if (new_id.charAt(0) == '.') {
                new_id = "";
            }
        } else if (new_id.length() >= 2) {
            if (new_id.charAt(0) == '.') {
                new_id = new_id.substring(1, new_id.length());
            }
            
            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        
        return new_id;
    }
    
    public String fifth(String new_id) {
        if (new_id == "") {
            return "a";
        } else {
            return new_id;
        }
    }
    
    public String sixth(String new_id) {
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
        }
        
        if (new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        return new_id;
    }
    
    public String seventh(String new_id) {
        StringBuilder result = new StringBuilder(new_id);
        
        if (new_id.length() == 1) {
            result.append(new_id);
            result.append(new_id);
        }
        
        if (new_id.length() == 2) {
            result.append(new_id.charAt(new_id.length() - 1));
        }
        
        return result.toString();
    }
}
