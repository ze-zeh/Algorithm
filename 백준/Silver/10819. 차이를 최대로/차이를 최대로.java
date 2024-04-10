import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static private int N;
    static private int Answer;
    static private int[] Arr;
    static private boolean[] Visited;

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Arr = new int[N];
        Visited = new boolean[N];
        Answer = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, new int[N]);

        System.out.println(Answer);
        br.close();
    }

    private static void backtracking(int depth, int[] arr) {
        if (depth == N) {
            Answer = Math.max(Answer, calc(arr));
        }

        for (int i = 0; i < N; i++) {
            if (!Visited[i]) {
                arr[depth] = Arr[i];
                Visited[i] = true;
                backtracking(depth + 1, arr);
                Visited[i] = false;
            }
        }
    }

    private static int calc(int[] arr) {
        int max = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            max += Math.abs(arr[i] - arr[i + 1]);
        }

        return max;
    }
}
