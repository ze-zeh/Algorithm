import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] downCount = new int[h + 2];
        int[] upCount = new int[h + 2];
        int min = n;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            int size = Integer.parseInt(br.readLine());

            if (i % 2 == 1) {
                downCount[size]++;
            } else {
                upCount[h - size + 1]++;
            }
        }

        for (int i = 1; i <= h; i++) {
            downCount[i] += downCount[i - 1];
        }

        for (int i = h; i >= 1; i--) {
            upCount[i] += upCount[i + 1];
        }

        for (int i = 1; i <= h; i++) {
            int x = (downCount[h] - downCount[i - 1]) + upCount[1] - upCount[i + 1];

            if (x < min) {
                min = x;
                count = 1;
            } else if (x == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);

        br.close();
    }
}
