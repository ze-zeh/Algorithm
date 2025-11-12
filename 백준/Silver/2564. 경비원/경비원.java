import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static Position pos;
    static Position[] stores;

    static class Position {
        int dir;
        int dist;

        Position(int x, int y) {
            this.dir = x;
            this.dist = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        stores = new Position[N];
        int answer = 0;
        int dir, dist;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            dir = Integer.parseInt(st.nextToken()) - 1;
            dist = Integer.parseInt(st.nextToken());

            dir = convertDir(dir);

            stores[i] = new Position(dir, dist);
        }

        st = new StringTokenizer(br.readLine());

        dir = Integer.parseInt(st.nextToken()) - 1;
        dist = Integer.parseInt(st.nextToken());

        dir = convertDir(dir);

        pos = new Position(dir, dist);

        for (Position store : stores) {
            answer += getShortest(store);
        }

        System.out.println(answer);
        br.close();
    }

    static int convertDir(int dir) {
        if (dir == 0) {
            return 0;
        } else if (dir == 1) {
            return 2;
        } else if (dir == 2) {
            return 3;
        } else if (dir == 3) {
            return 1;
        }

        return dir;
    }

    static int getShortest(Position store) {
        int diff = Math.abs(pos.dir - store.dir);

        if (diff == 0) {
            return Math.abs(pos.dist - store.dist);
        } else if (diff == 2) {
            if (pos.dir == 0 || pos.dir == 2) {
                return C + Math.min(pos.dist + store.dist, R - pos.dist + R - store.dist);
            } else {
                return R + Math.min(pos.dist + store.dist, C - pos.dist + C - store.dist);
            }
        } else {
            if (pos.dir == 0 && store.dir == 1) {
                return R - pos.dist + store.dist;
            } else if (pos.dir == 1 && store.dir == 2) {
                return C - pos.dist + R - store.dist;
            } else if (pos.dir == 2 && store.dir == 3) {
                return pos.dist + C - store.dist;
            } else if (pos.dir == 1 && store.dir == 0) {
                return pos.dist + R - store.dist;
            } else if (pos.dir == 2 && store.dir == 1) {
                return R - pos.dist + C - store.dist;
            } else if (pos.dir == 3 && store.dir == 2) {
                return C - pos.dist + store.dist;
            } else {
                return pos.dist + store.dist;
            }
        }
    }
}
