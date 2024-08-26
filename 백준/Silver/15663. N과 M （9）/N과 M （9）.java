import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static int M;
    static ArrayList<Integer> List;
    static Set<ArrayList<Integer>> Set;
    static boolean[] Visited;
    static int[] Arr;


    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List = new ArrayList<>();
        Visited = new boolean[N];
        Arr = new int[N];
        Set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Arr);
        backtracking(0);

        for (ArrayList<Integer> list : Set) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        br.close();
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            Set.add(new ArrayList<>(List));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!Visited[i]) {
                Visited[i] = true;
                List.add(Arr[i]);
                backtracking(depth + 1);
                List.remove(List.size() - 1);
                Visited[i] = false;
            }
        }
    }
}