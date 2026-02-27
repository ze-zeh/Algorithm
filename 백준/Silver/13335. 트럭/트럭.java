import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static List<int[]> bridge;
    static int capacity;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        bridge = new ArrayList<>();
        capacity = 0;
        int answer = 1;
        int idx = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        bridge.add(new int[]{a[idx], w});
        capacity += a[idx];
        idx++;

        while (!bridge.isEmpty()) {
            answer++;
            time();

            if (idx < n && capacity + a[idx] <= L) {
                bridge.add(new int[]{a[idx], w});
                capacity += a[idx];
                idx++;
            }
        }

        System.out.println(answer);

        br.close();
    }

    public static void time() {
        for (int i = bridge.size() - 1; i >= 0; i--) {
            bridge.get(i)[1]--;

            if (bridge.get(i)[1] == 0) {
                capacity -= bridge.get(i)[0];
                bridge.remove(i);
            }
        }
    }
}
