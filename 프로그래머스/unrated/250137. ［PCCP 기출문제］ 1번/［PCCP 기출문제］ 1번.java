class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int max_time = attacks[attacks.length - 1][0];
        int heal_time = 0;
        int cur_attack = 0;
        
        for (int i = 1; i <= max_time; i++) {
            heal_time++;
            
            if (attacks[cur_attack][0] == i) {
                answer -= attacks[cur_attack][1];
                cur_attack++;
                heal_time = 0;
            } else {
                int heal = bandage[1];
                
                if (heal_time == bandage[0]) {
                    heal += bandage[2];
                    heal_time = 0;
                }
                
                answer += heal;
            }
            
            
            if (health < answer) {
                answer = health;
            }
            
            if (answer <= 0) {
                return -1;
            }
        }
        
        return answer;
    }
}