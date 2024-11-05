import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        int[] dpL = new int[N + 1];
        int[] dpR = new int[N + 1];
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dpL[i] = 1;
            dpR[i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dpL[i] = Math.max(dpL[j] + 1, dpL[i]);
                }
            }
        }

        for (int i = N; i > 0; i--) {
            for (int j = N; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dpR[i] = Math.max(dpR[j] + 1, dpR[i]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dpL[i] + dpR[i]);
        }

        System.out.println(answer - 1);

        br.close();
    }
}