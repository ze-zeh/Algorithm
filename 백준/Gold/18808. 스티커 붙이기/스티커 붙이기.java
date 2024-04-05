import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static class Sticker {
        int r;
        int c;
        int[][] shape;

        Sticker(int r, int c, int[][] shape) {
            this.r = r;
            this.c = c;
            this.shape = shape;
        }
    }

    static int N;
    static int M;
    static int K;
    static int[][] Map;
    static int Answer;
    static Sticker[] Stickers;

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        Answer = Integer.MAX_VALUE;
        Stickers = new Sticker[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[r][c];

            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < c; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            Stickers[i] = new Sticker(r, c, sticker);
        }

        for (int i = 0; i < K; i++) {
            putSticker(Stickers[i]);
        }

        System.out.println(count(Map));

        br.close();
    }

    static private boolean isPastable(Sticker sticker, int i, int j) {
        for (int x = 0; x < sticker.r; x++) {
            for (int y = 0; y < sticker.c; y++) {
                if (Map[i + x][j + y] == 1 && sticker.shape[x][y] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    static private void paste(Sticker sticker, int i, int j) {
        for (int x = 0; x < sticker.r; x++) {
            for (int y = 0; y < sticker.c; y++) {
                if (sticker.shape[x][y] == 1) {
                    Map[i + x][j + y] = 1;
                }
            }
        }
    }

    static private void putSticker(Sticker sticker) {
        for (int n = 0; n < 4; n++) {
            for (int i = 0; i <= N - sticker.r; i++) {
                for (int j = 0; j <= M - sticker.c; j++) {
                    if (isPastable(sticker, i, j)) {
                        paste(sticker, i, j);
                        return;
                    }
                }
            }

            sticker = rotate(sticker);
        }
    }

    static private Sticker rotate(Sticker sticker) {
        int[][] newShape = new int[sticker.c][sticker.r];

        for (int i = 0; i < sticker.c; i++) {
            for (int j = sticker.r - 1; j >= 0; j--) {
                newShape[i][sticker.r - 1 - j] = sticker.shape[j][i];
            }
        }

        return new Sticker(sticker.c, sticker.r, newShape);
    }

    static int count(int[][] map) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    static void printSticker(int[][] sticker) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                System.out.print(sticker[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
