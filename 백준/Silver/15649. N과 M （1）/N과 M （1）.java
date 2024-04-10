import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static private int N;
    static private int M;
    static private boolean[] Visited;
    static private int[] Arr;

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Visited = new boolean[N];
        Arr = new int[N];

        backtracking(0);
        br.close();
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(Arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!Visited[i]) {
                Arr[depth] = i + 1;
                Visited[i] = true;
                backtracking(depth + 1);
                Visited[i] = false;
            }
        }
    }
}
