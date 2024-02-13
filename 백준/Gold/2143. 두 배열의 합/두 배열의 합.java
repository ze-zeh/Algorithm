import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        long answer = 0;
        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += a[j];
                listA.add(sum);
            }
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;

            for (int j = i; j < m; j++) {
                sum += b[j];
                listB.add(sum);
            }
        }

        Collections.sort(listA);
        Collections.sort(listB);

        int pA = 0;
        int pB = listB.size() - 1;

        while (pA < listA.size() && pB >= 0) {
            int sum = listA.get(pA) + listB.get(pB);

            if (sum == t) {
                long x = listA.get(pA);
                long y = listB.get(pB);
                long countA = 0;
                long countB = 0;

                while (pA < listA.size() && listA.get(pA) == x) {
                    countA++;
                    pA++;
                }

                while (pB >= 0 && listB.get(pB) == y) {
                    countB++;
                    pB--;
                }

                answer += countA * countB;
            } else if (sum > t) {
                pB--;
            } else if (sum < t) {
                pA++;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
