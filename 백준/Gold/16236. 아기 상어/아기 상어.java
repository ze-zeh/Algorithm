import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int X, Y;
    static int size, answer, fullness;
    static int[][] map;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        size = 2;
        answer = 0;
        fullness = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    X = i;
                    Y = j;
                    map[i][j] = 0;
                }
            }
        }

        move();
        System.out.println(answer);

        br.close();
    }

    private static void move() {
        while (bfs()) {
            if (++fullness == size) {
                fullness = 0;
                size++;
            }
        }
    }

    private static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int minTime = Integer.MAX_VALUE;
        int x = X;
        int y = Y;
        boolean result = false;

        queue.add(new int[]{X, Y, 0});
        visited[X][Y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < size) {
                result = true;

                if (minTime < cur[2]) {
                    break;
                } else if (minTime > cur[2]) {
                    minTime = cur[2];
                    x = cur[0];
                    y = cur[1];
                }

                if (x > cur[0] || (x == cur[0] && y > cur[1])) {
                    x = cur[0];
                    y = cur[1];
                }

            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!checkRange(nx, ny) || visited[nx][ny] || map[nx][ny] > size) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, cur[2] + 1});
            }
        }

        if (result) {
            X = x;
            Y = y;
            answer += minTime;
            map[X][Y] = 0;
        }

        return result;
    }

    private static boolean checkRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}