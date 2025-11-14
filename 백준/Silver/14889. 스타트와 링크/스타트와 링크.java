import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int A, B;
    static int[] team;
    static int[] enemy;
    static int[][] map;
    static int[] pair;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        team = new int[N / 2];
        enemy = new int[N / 2];
        pair = new int[2];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(1, 1);

        System.out.println(answer);
        br.close();
    }

    public static void combination(int start, int count) {
        if (count == N / 2) {
            calculate();
            return;
        }
        if (start >= N) {
            return;
        }

        team[count] = start;
        combination(start + 1, count + 1);
        team[count] = start;
        combination(start + 1, count);
    }

    private static void calculate() {
        int index = 0;
        A = 0;
        B = 0;

        for (int i = 0; i < N; i++) {
            boolean isContain = false;

            for (int t : team) {
                if (t == i) {
                    isContain = true;
                    break;
                }
            }

            if (!isContain) {
                enemy[index++] = i;
            }
        }

        combination2(team, 0, 0, true);
        combination2(enemy, 0, 0, false);

        answer = Math.min(answer, Math.abs(A - B));
    }

    public static void combination2(int[] team, int start, int count, boolean isTeam) {
        if (count == 2) {
            if (isTeam) {
                A += map[pair[0]][pair[1]] + map[pair[1]][pair[0]];
            } else {
                B += map[pair[0]][pair[1]] + map[pair[1]][pair[0]];
            }

            return;
        }

        if (start >= team.length) {
            return;
        }

        pair[count] = team[start];
        combination2(team, start + 1, count + 1, isTeam);
        combination2(team, start + 1, count, isTeam);
    }
}