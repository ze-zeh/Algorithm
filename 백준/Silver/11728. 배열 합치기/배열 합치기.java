import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int x = 0, y = 0;

        while (x < n && y < m) {
            if (a[x] <= b[y]) {
                sb.append(a[x++] + " ");
            } else {
                sb.append(b[y++] + " ");
            }
        }

        if (x == n) {
            for (int i = y; i < m; i++) {
                sb.append(b[i] + " ");
            }
        } else {
            for (int i = x; i < n; i++) {
                sb.append(a[i] + " ");
            }
        }

        System.out.println(sb);
        br.close();
    }
}