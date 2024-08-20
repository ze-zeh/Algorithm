import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int answer = 0;
        int start = 0;
        int end = n - 1;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        while (start < end) {

            if (arr[start] + arr[end] > x) {
                end--;
            } else if (arr[start] + arr[end] < x) {
                start++;
            } else {
                answer++;
                start++;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
