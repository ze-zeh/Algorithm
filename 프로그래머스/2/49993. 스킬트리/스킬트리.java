class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String skill_tree : skill_trees) {
            String tree = "";
            
            for (int i = 0; i < skill_tree.length(); i++) {	
                String s = skill_tree.charAt(i) + "";
                
                if (skill.contains(s)) {
                    tree += s;
                }
            }
            
            if (skill.startsWith(tree)) {
                answer++;
            }
        }
        
        return answer;
    }
}