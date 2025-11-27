import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) / 1000;
        int[][] arr = new int[N][2];
        int answer = 0;
        int k = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> (o2[0] - o2[1]) - (o1[0] - o1[1]));

        for (int i = 0; (i + 1) * 4 <= X - N; i++) {
            if (arr[i][0] < arr[i][1]) {
                break;
            }

            answer += arr[i][0];
            k = i + 1;
        }

        for (int i = k; i < N; i++) {
            answer += arr[i][1];
        }

        System.out.println(answer);

        br.close();
    }
}