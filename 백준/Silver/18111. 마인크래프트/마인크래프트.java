import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int time = Integer.MAX_VALUE;
        int height = 0;
        int maxHeight = Integer.MIN_VALUE;
        int minHeight = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                maxHeight = Math.max(maxHeight, map[i][j]);
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }

        for (int h = maxHeight; h >= minHeight; h--) {
            int remain = B;
            int t = 0;
            boolean flag = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (h > map[i][j]) {
                        int diff = h - map[i][j];
                        remain -= diff;
                        t += diff;
                    } else if (h < map[i][j]) {
                        int diff = map[i][j] - h;
                        remain += diff;
                        t += diff * 2;
                    }

                    if (t > time) {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    break;
                }
            }

            if (flag || remain < 0) {
                continue;
            }

            if (time > t) {
                time = t;
                height = h;
            }
        }

        System.out.println(time + " " + height);

        br.close();
    }
}
