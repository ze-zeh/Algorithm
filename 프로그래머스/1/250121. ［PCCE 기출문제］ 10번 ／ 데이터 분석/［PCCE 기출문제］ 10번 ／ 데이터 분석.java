import java.util.*;

class Solution {
    static final String[] Arr = {"code", "date", "maximum", "remain"};
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        int extIdx = 0;
        int sortIdx = 0;
        
        for (int i = 0; i < Arr.length; i++) {
            if (ext.equals(Arr[i])) extIdx = i;
            if (sort_by.equals(Arr[i])) sortIdx = i;
        }
        
        final int idx = sortIdx;
        
        for (int[] d : data) {
            if (d[extIdx] < val_ext) list.add(d);
        }
        
        Collections.sort(list, (o1, o2) -> o1[idx] - o2[idx]);
        
        return list.toArray(new int[list.size()][]);
    }
}