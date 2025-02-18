import java.util.*;

class Solution {
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = findGene(queries[i][0], queries[i][1] - 1);
        }

        return answer;
    }

    public String findGene(int n, int p) {
        if (n == 1) {
            return "Rr";
        }

        String parentGene = findGene(n - 1, p / 4);

        if (parentGene.equals("Rr")) {
            int k = p % 4;

            if (k == 0) {
                return "RR";
            } else if (k == 3) {
                return "rr";
            } else {
                return "Rr";
            }
        } else {
            return parentGene;
        }
    }
}