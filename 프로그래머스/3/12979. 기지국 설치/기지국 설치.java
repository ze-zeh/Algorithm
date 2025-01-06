class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int before = 1;
        int idx = 0;
        
	    while (before <= n) {
		    if (idx < stations.length && before >= stations[idx] - w) {
			    before = stations[idx] + w + 1;
			    idx++;
 		    } else {
                before += w * 2 + 1;
                answer++;
		    }
	    }
        
        return answer;
    }
}