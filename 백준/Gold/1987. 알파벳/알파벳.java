import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int R;
    static int C;
    static int Answer;
    static char[][] Map;
    static int[] Dx = {-1, 0, 1, 0};
    static int[] Dy = {0, -1, 0, 1};

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Answer = 0;
        Map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();

            for (int j = 0; j < C; j++) {
                Map[i][j] = str.charAt(j);
            }
        }

        dfs(new boolean[26], 0, 0);

        System.out.println(Answer);
        br.close();
    }

    private static void dfs(boolean[] arr, int x, int y) {
        arr[Map[x][y] - 'A'] = true;
        int count = count(arr);
        Answer = Math.max(Answer, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + Dx[i];
            int ny = y + Dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !arr[Map[nx][ny] - 'A']) {
                dfs(arr, nx, ny);
            }
        }

        arr[Map[x][y] - 'A'] = false;
    }

    static private int count(boolean[] arr) {
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (arr[i]) count++;
        }

        return count;
    }
}
