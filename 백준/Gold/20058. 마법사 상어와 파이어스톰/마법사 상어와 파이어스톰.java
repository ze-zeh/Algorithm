import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static int[][] A;
    static boolean[][] Visited;
    static int[] Dx = {-1, 0, 1, 0};
    static int[] Dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = 1 << Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        Visited = new boolean[N][N];
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < Q; i++) {
            int L = 1 << Integer.parseInt(st.nextToken());

            firestorm(L);
            melt();
        }

        getSum();
        getMax();
        br.close();
    }

    private static void firestorm(int l) {
        int[][] copy = copy(A);

        for (int i = 0; i < N; i += l) {
            for (int j = 0; j < N; j += l) {
                rotate(l, i, j, copy);
            }
        }
    }

    private static void rotate(int l, int x, int y, int[][] copy) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                A[x + i][y + j] = copy[x + l - 1 - j][y + i];
            }
        }
    }

    private static int[][] copy(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] c = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i][j] = a[i][j];
            }
        }

        return c;
    }

    private static void melt() {
        int[][] copy = copy(A);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;

                if (copy[i][j] == 0) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = i + Dx[k];
                    int ny = j + Dy[k];

                    if (checkRange(nx, ny) && copy[nx][ny] > 0) {
                        count++;
                    }
                }

                if (count < 3) {
                    A[i][j]--;
                }
            }
        }
    }

    public static void getSum() {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += A[i][j];
            }
        }

        System.out.println(sum);
    }

    private static void getMax() {
        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!Visited[i][j] && A[i][j] != 0) {
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.println(max);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;

        queue.add(new int[]{x, y});
        Visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + Dx[i];
                int ny = cur[1] + Dy[i];

                if (!checkRange(nx, ny) || Visited[nx][ny] || A[nx][ny] == 0) {
                    continue;
                }

                queue.add(new int[]{nx, ny});
                Visited[nx][ny] = true;
            }
        }

        return count;
    }

    private static boolean checkRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}