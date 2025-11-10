import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] Map;
    static int[] Dx = {1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] Dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    final static int BLANK = 0;
    final static int I = 1;
    final static int CRAZY = 2;
    final static int EXPLODE = 3;
    static int[] IPos;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();

            for (int j = 0; j < C; j++) {
                char ch = str.charAt(j);

                if (ch == 'I') {
                    Map[i][j] = I;
                    IPos = new int[]{i, j};
                } else if (ch == 'R') {
                    Map[i][j] = CRAZY;
                }
            }
        }

        String commands = br.readLine();

        for (int i = 0; i < commands.length(); i++) {
            int command = commands.charAt(i) - '1';

            if (move(command)) {
                System.out.println("kraj " + (i + 1));
                return;
            }
        }

        printMap(Map);
        br.close();
    }

    public static boolean move(int command) {
        int[][] newMap = new int[R][C];

        IPos = new int[]{IPos[0] + Dx[command], IPos[1] + Dy[command]};

        if (Map[IPos[0]][IPos[1]] == CRAZY) {
            return true;
        }

        newMap[IPos[0]][IPos[1]] = I;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (Map[i][j] == CRAZY) {
                    int[] newPos = getNewPos(i, j);
                    int nx = newPos[0];
                    int ny = newPos[1];

                    if (newMap[nx][ny] == I) {
                        return true;
                    } else if (newMap[nx][ny] == BLANK) {
                        newMap[nx][ny] = CRAZY;
                    } else {
                        newMap[nx][ny] = EXPLODE;
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (newMap[i][j] == EXPLODE) {
                    newMap[i][j] = BLANK;
                }
            }
        }

        Map = newMap;

        return false;
    }

    private static int[] getNewPos(int i, int j) {
        int nx = i;
        int ny = j;

        if (i > IPos[0]) {
            if (j > IPos[1]) {
                nx += Dx[6];
                ny += Dy[6];
            } else if (j < IPos[1]) {
                nx += Dx[8];
                ny += Dy[8];
            } else {
                nx += Dx[7];
                ny += Dy[7];
            }
        } else if (i < IPos[0]) {
            if (j > IPos[1]) {
                nx += Dx[0];
                ny += Dy[0];
            } else if (j < IPos[1]) {
                nx += Dx[2];
                ny += Dy[2];
            } else {
                nx += Dx[1];
                ny += Dy[1];
            }
        } else {
            if (j > IPos[1]) {
                nx += Dx[3];
                ny += Dy[3];
            } else if (j < IPos[1]) {
                nx += Dx[5];
                ny += Dy[5];
            }
        }

        return new int[]{nx, ny};
    }

    private static void printMap(int[][] map) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == I) {
                    System.out.print('I');
                } else if (map[i][j] == CRAZY) {
                    System.out.print('R');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }
}
