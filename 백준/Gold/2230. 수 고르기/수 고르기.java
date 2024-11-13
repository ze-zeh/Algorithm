import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = 1;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        while (right < N) {
            int gap = arr[right] - arr[left];

            if (gap == M) {
                answer = M;
                break;
            } else if (gap < M) {
                right++;
            } else {
                left++;
                answer = Math.min(answer, gap);
            }
        }

        System.out.println(answer);
    }
}