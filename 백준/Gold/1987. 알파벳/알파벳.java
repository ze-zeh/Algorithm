import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int R;
    static int C;
    static int Answer;
    static char[][] Map;
    static boolean[] Visited;
    static int[] Dx = {-1, 0, 1, 0};
    static int[] Dy = {0, -1, 0, 1};

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Answer = 0;
        Map = new char[R][C];
        Visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();

            for (int j = 0; j < C; j++) {
                Map[i][j] = str.charAt(j);
            }
        }

        backtracking(0, 0, 1);

        System.out.println(Answer);
        br.close();
    }

    private static void backtracking(int x, int y, int depth) {
        Visited[Map[x][y] - 'A'] = true;
        Answer = Math.max(Answer, depth);

        for (int i = 0; i < 4; i++) {
            int nx = x + Dx[i];
            int ny = y + Dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !Visited[Map[nx][ny] - 'A']) {
                backtracking(nx, ny, depth + 1);
            }
        }

        Visited[Map[x][y] - 'A'] = false;
    }
}
