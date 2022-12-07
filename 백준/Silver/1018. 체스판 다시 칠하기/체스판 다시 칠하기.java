import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static boolean[][] board;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(input.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = input.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j) == 'W';
            }
        }

        int min = 64;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                min = Math.min(min, count(i, j));
            }
        }

        System.out.println(min);
    }

    public static int count(int i, int j) {
        int count = 0;
        boolean b = board[i][j];
        for (int x = i; x < i+ 8; x++) {
            for (int y = j; y < j + 8; y++) {
                if (board[x][y] != b) {
                    count++;
                }
                b = !b;
            }
            b = !b;
        }
        return Math.min(count, 64 - count);
    }
}
