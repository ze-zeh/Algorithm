import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, M, K;
    static int a, b;
    static boolean[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
                char ch = s.charAt(j);

                if (ch == '*') {
                    map[i][j] = true;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            simulate();
        }

        printMap();

        br.close();
    }

    private static void simulate() {
        boolean[][] newMap = copyArr(map);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = isSurvived(i, j);
            }
        }

        map = newMap;
    }

    public static boolean[][] copyArr(boolean[][] arr) {
        boolean[][] newArr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArr[i][j] = arr[i][j];
            }
        }

        return newArr;
    }

    public static boolean isSurvived(int x, int y) {
        boolean survived = map[x][y];
        int count = countNearby(x, y);

        if (survived) {
            return count >= a && count <= b;
        } else {
            if (count > a && count <= b) {
                return true;
            }
        }

        return false;
    }

    public static int countNearby(int x, int y) {
        int count = 0;
        int topBound = Math.max(x - K, 0);
        int bottomBound = Math.min(x + K, N - 1);
        int leftBound = Math.max(y - K, 0);
        int rightBound = Math.min(y + K, M - 1);

        for (int i = topBound; i <= bottomBound; i++) {
            for (int j = leftBound; j <= rightBound; j++) {
                if (i == x && j == y) {
                    continue;
                }

                if (map[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j]) {
                    System.out.print('*');
                } else {
                    System.out.print('.');
                }
            }

            System.out.println();
        }
    }
}
