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
        int left = 0;
        int right = n - 1;
        int min = Integer.MAX_VALUE;
        int minLeft = -1;
        int minRight = -1;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        while (left < right) {
            int sum = Math.abs(arr[right] + arr[left]);

            if (sum < min) {
                min = sum;
                minLeft = arr[left];
                minRight = arr[right];
            }

            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                left++;
            } else {
                right--;
            }
        }

        System.out.print(minLeft + " " + minRight);

        br.close();
    }
}