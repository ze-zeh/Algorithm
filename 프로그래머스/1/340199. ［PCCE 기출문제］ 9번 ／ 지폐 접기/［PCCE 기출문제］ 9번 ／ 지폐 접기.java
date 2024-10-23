class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int wLong, wShort;
        int bLong, bShort;
        
        if (wallet[0] >= wallet[1]) {
            wLong = wallet[0];
            wShort = wallet[1];
        } else {
            wLong = wallet[1];
            wShort = wallet[0];
        }
        
        if (bill[0] >= bill[1]) {
            bLong = bill[0];
            bShort = bill[1];
        } else {
            bLong = bill[1];
            bShort = bill[0];
        }
        
        while (wLong < bLong || wShort < bShort) {
            bLong /= 2;
            answer++;
            
            if (bLong < bShort) {
                int tmp = bLong;
                bLong = bShort;
                bShort = tmp;
            }
        }
        
        return answer;
    }
}