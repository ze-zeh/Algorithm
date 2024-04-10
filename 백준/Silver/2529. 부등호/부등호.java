import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static private int K;
    static private String[] A;
    static private boolean[] Visited;
    static private ArrayList<String> List;

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        A = new String[K];
        Visited = new boolean[10];
        List = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            A[i] = st.nextToken();
        }

        backtracking("", 0);

        System.out.println(List.get(List.size() - 1));
        System.out.println(List.get(0));

        br.close();
    }

    private static void backtracking(String num, int depth) {
        if (depth == K + 1) {
            List.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (Visited[i]) continue;

            if (depth == 0 || check(num.charAt(depth - 1) - '0', i, A[depth - 1])) {
                Visited[i] = true;
                backtracking(num + i, depth + 1);
                Visited[i] = false;
            }
        }
    }

    static private boolean check(int a, int b, String num) {
        if (num.equals(">")) {
            if (a < b) return false;
        } else if (num.equals("<")) {
            if (a > b) return false;
        }
        return true;
    }
}
