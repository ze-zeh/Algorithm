import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = input.nextInt();
        int[][] wh = new int[n][2];
        for (int i = 0; i < n; i++) {
            wh[i][0] = input.nextInt();
            wh[i][1] = input.nextInt();
        }
        int[] result = new int[n];
        Arrays.fill(result, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (wh[i][0] < wh[j][0] && wh[i][1] < wh[j][1]) {
                    result[i]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.print(sb);
    }
}
