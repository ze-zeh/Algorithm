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

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        int left = 0;
        int right = arr[n - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                sum += Math.min(arr[i], mid);
            }

            if (sum <= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);

        br.close();
    }
}
