import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 1;
        int end = arr[N - 1] - arr[0] + 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (canInstall(mid) < C) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start - 1);
    }

    public static int canInstall(int distance) {
        int count = 1;
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];

            if (cur - last >= distance) {
                count++;
                last = cur;
            }
        }
        
        return count;
    }
}
