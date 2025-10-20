import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static boolean[][] Laptop;

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Laptop = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            boolean[][] sticker = new boolean[R][C];

            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 0; c < C; c++) {
                    int cell = Integer.parseInt(st.nextToken());

                    sticker[r][c] = cell == 1;
                }
            }

            for (int dir = 0; dir < 4; dir++) {
                if (attachSticker(sticker, dir)) {
                    break;
                }
            }
        }

        System.out.println(countCell());
        br.close();
    }

    static public boolean attachSticker(boolean[][] sticker, int dir) {
        if (dir != 0) {
            sticker = rotate(sticker, dir);
        }

        int r = sticker.length;
        int c = sticker[0].length;

        for (int i = 0; i < N - r + 1; i++) {
            for (int j = 0; j < M - c + 1; j++) {
                if (isAttachable(sticker, i, j)) {
                    attach(sticker, i, j);
                    return true;
                }
            }
        }

        return false;
    }

    static public boolean[][] rotate(boolean[][] sticker, int dir) {
        int r = dir == 2 ? sticker.length : sticker[0].length;
        int c = dir == 2 ? sticker[0].length : sticker.length;
        boolean[][] rSticker = new boolean[r][c];

        if (dir == 1) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    rSticker[i][j] = sticker[c - 1 - j][i];
                }
            }
        } else if (dir == 2) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    rSticker[i][j] = sticker[r - 1 - i][c - 1 - j];
                }
            }
        } else {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    rSticker[i][j] = sticker[j][r - 1 - i];
                }
            }
        }

        return rSticker;
    }

    static public boolean isAttachable(boolean[][] sticker, int x, int y) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j]) {
                    if (Laptop[x + i][y + j]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    static public void attach(boolean[][] sticker, int x, int y) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j]) {
                    Laptop[x + i][y + j] = true;
                }
            }
        }
    }

    static public int countCell() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Laptop[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
