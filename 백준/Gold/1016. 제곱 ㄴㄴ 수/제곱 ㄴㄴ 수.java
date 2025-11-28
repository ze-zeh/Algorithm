import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int size = (int) (max - min + 1);
        boolean[] isSquare = new boolean[size];
        int answer = 0;

        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            long start = (min + square - 1) / square;
            long value = start * square;

            for (long j = value; j <= max; j += square) {
                isSquare[(int) (j - min)] = true;
            }
        }

        for (int i = 0; i < size; i++) {
            if (!isSquare[i]) {
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
