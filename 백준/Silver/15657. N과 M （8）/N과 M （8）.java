import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int M;
    static int[] Nums;

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Nums);
        backtracking(0, "", 0);

        br.close();
    }

    static public void backtracking(int depth, String str, int max) {
        if (depth == M) {
            System.out.println(str);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (Nums[i] < max) continue;

            max = Math.max(max, Nums[i]);
            backtracking(depth + 1, str + Nums[i] + " ", max);
        }
    }
}
