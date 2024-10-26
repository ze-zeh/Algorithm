class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        
        for(int[] size : sizes){
            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);
            
            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }
        
        return maxW * maxH;
    }
}