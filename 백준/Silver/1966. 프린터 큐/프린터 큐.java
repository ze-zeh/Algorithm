import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Queue<Integer> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[10];
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int result = 0;

            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
                arr[num]++;
            }

            while (!queue.isEmpty()) {
                boolean flag = false;
                int cur = queue.poll();

                for (int k = 9; k > cur; k--) {
                    if (arr[k] > 0) {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    queue.add(cur);
                } else {
                    arr[cur]--;
                    result++;
                    if (m == 0) {
                        break;
                    }
                }

                if (m == 0) {
                    m = queue.size() - 1;
                } else {
                    m--;
                }
            }
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}