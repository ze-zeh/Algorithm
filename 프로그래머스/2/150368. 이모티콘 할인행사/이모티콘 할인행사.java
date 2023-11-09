class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] ratio = new int[emoticons.length];
        int eLength = emoticons.length;
        int times = times(4, eLength);
        int maxPlus = 0;
        int maxBenefit = 0;
        
        for (int i = 0 ; i < times; i++) {
            int a = i;
            
            for (int j = 0 ; j < eLength; j++){
                int plus = 0;
                int benefit = 0;
                
                ratio[j] = a % 4;
                a /= 4;
                
                for (int[] user : users) {
                    int cost = 0;
                    int userRatio = user[0];
                    int userPrice = user[1];
                    
                    for (int k = 0; k < eLength; k++) {
                        int r = (ratio[k] + 1) * 10;
                        
                        if (r >= userRatio) {
                            cost += emoticons[k] * (100 - r) / 100;
                        }
                    }
                    
                    if (cost >= userPrice) {
                        plus++;
                    } else {
                        benefit += cost;
                    }
                }
                
                if (maxPlus < plus) {
                    maxPlus = plus;
                    maxBenefit = benefit;
                } else if (maxPlus == plus) {
                    maxBenefit = Math.max(maxBenefit, benefit);
                }
            }
        }
        
        answer[0] = maxPlus;
        answer[1] = maxBenefit;
        
        return answer;
    }
    
    public int times(int n, int count) {
        int result = 1;
        
        for (int i = 0; i < count; i++) {
            result *= n;
        }
        
        return result;
    }
}
