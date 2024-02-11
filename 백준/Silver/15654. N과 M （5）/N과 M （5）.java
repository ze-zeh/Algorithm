import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static StringBuilder Sb = new StringBuilder();
    static int[] Nums;
    static int[] Arr;
    static int N;
    static int M;
    static boolean[] Visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Nums = new int[N];
        Arr = new int[N];
        Visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            Nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Nums);
        backTracking(0);
        System.out.print(Sb);

        br.close();
    }

    private static void backTracking(int length) {
        if (length == M) {
            for (int i = 0; i < M; i++) {
                Sb.append(Arr[i]).append(" ");
            }
            Sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!Visited[i]) {
                Visited[i] = true;
                Arr[length] = Nums[i];
                backTracking(length + 1);
                Visited[i] = false;
            }
        }
    }
}
