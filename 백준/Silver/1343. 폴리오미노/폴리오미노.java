import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String board = br.readLine();

        for (int i = 0; i < board.length(); i++) {
            int count = 0;

            if (board.charAt(i) == '.') {
                sb.append('.');
                continue;
            }

            while (i < board.length() && board.charAt(i) == 'X') {
                count++;
                i++;
            }

            i--;

            if (count % 2 == 1) {
                System.out.println(-1);
                return;
            }

            for (int j = 0; j < count / 4; j++) {
                sb.append("AAAA");
            }

            if (count % 4 == 2) {
                sb.append("BB");
            }
        }

        System.out.println(sb);
    }
}