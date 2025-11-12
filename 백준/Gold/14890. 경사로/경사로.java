import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            int[] road = new int[N];

            for (int j = 0; j < N; j++) road[j] = map[j][i];

            if (checkRoad(road)) answer++;
            if (checkRoad(map[i])) answer++;
        }

        System.out.println(answer);
        br.close();
    }

    static boolean checkRoad(int[] road) {
        int before = road[0];
        int count = 1;

        for (int i = 1; i < N; i++) {
            if (road[i] != before) {
                if ((road[i] > before && count < L) || Math.abs(road[i] - before) > 1) {
                    return false;
                }

                if (road[i] < before) {
                    before = road[i];

                    for (int j = 0; j < L; j++) {
                        if (i + j >= N || before != road[i + j]) {
                            return false;
                        }
                    }

                    i += L - 1;
                    before = road[i];
                    count = 0;
                    continue;
                }

                before = road[i];
                count = 1;
            } else {
                count++;
            }
        }

        return true;
    }
}
