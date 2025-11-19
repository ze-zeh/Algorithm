import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int SHARK = -1;
    static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][][] map = new int[4][4][2];
        answer = 0;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken());
                map[i][j][1] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        map[0][0][0] *= (-1);

        solve(map);
        System.out.println(answer);

        br.close();
    }

    private static void solve(int[][][] map) {
        int[][][] newMap = copyMap(map);

        for (int i = 1; i <= 16; i++) {
            int[] pos = findPos(newMap, i);
            int x = pos[0];
            int y = pos[1];

            if (x == -1 || y == -1) {
                continue;
            }

            newMap = moveFish(x, y, newMap);
        }

        for (int i = 1; i <= 3; i++) {
            int beforeSize = getSharkSize(newMap);
            int[][][] result = moveShark(newMap, i);
            int afterSize = getSharkSize(result);

            if (afterSize == beforeSize) {
                answer = Math.max(answer, afterSize);
                continue;
            }

            solve(result);
        }
    }

    public static int[][][] moveFish(int x, int y, int[][][] map) {
        int dir = map[x][y][1];
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (!checkRange(nx, ny) || map[nx][ny][0] < 0) {
            dir = (dir + 9) % 8;
            nx = x + dx[dir];
            ny = y + dy[dir];
            map[x][y][1] = dir;
        }

        if (map[nx][ny][0] == 0) {
            map[nx][ny] = map[x][y];
            map[x][y] = new int[2];
        } else {
            int[] tmp = new int[2];
            tmp[0] = map[nx][ny][0];
            tmp[1] = map[nx][ny][1];
            map[nx][ny] = map[x][y];
            map[x][y] = tmp;
        }

        return map;
    }

    public static int[][][] moveShark(int[][][] map, int dist) {
        int[][][] newMap = copyMap(map);
        int[] pos = findPos(newMap, SHARK);
        int dir = newMap[pos[0]][pos[1]][1];
        int x = pos[0];
        int y = pos[1];
        int nx = x + dx[dir] * dist;
        int ny = y + dy[dir] * dist;

        if (!checkRange(nx, ny) || newMap[nx][ny][0] == 0) {
            return newMap;
        }

        newMap[x][y][0] -= newMap[nx][ny][0];
        newMap[x][y][1] = newMap[nx][ny][1];
        newMap[nx][ny] = newMap[x][y];
        newMap[x][y] = new int[2];

        return newMap;
    }

    public static int[] findPos(int[][][] map, int num) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((num > 0 && map[i][j][0] == num) || (num < 0 && map[i][j][0] < 0)) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static int getSharkSize(int[][][] map) {
        int[] pos = findPos(map, SHARK);

        return Math.abs(map[pos[0]][pos[1]][0]);
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }

    public static int[][][] copyMap(int[][][] map) {
        int[][][] newMap = new int[4][4][2];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    newMap[i][j][k] = map[i][j][k];
                }
            }
        }

        return newMap;
    }
}