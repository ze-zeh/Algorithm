import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        long left = 1;
        long right = 0;
        long answer = 0;

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }

        while (left <= right) {
            long mid = (left + right) / 2;
            int count = 0;

            for (int i = 0; i < k; i++) {
                count += arr[i] / mid;
            }

            if (count >= n) {
                left = mid + 1;
                answer = Math.max(mid, answer);
            } else {
                right = mid - 1;
            }
        }

        System.out.print(answer);

        br.close();
    }
}
