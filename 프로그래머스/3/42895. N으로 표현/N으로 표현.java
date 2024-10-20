import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            list.add(new HashSet<>());
        }

        list.get(1).add(N);

        for (int i = 2; i <= 8; i++){
            Set<Integer> set = list.get(i);

            for(int j = 1; j <= i; j++){
                Set<Integer> preSet = list.get(j);
                Set<Integer> postSet = list.get(i - j);

                for (int preNum : preSet) {
                    for (int postNum : postSet) {
                        set.add(preNum + postNum);
                        set.add(preNum - postNum);
                        set.add(preNum * postNum);

                        if (preNum != 0 && postNum != 0) {
                            set.add(preNum / postNum);
                        }
                    }
                }
            }

            set.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        for (Set<Integer> set : list){
            if (set.contains(number)) {
                return list.indexOf(set);
            }
        }

        return -1;
    }
}