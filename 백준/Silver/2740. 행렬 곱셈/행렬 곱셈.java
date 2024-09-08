import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k;
        int[][] a = new int[n][m];
        int[][] b;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        b = new int[m][k];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < k; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        multiple(a, b);
        br.close();
    }

    private static void multiple(int[][] a, int[][] b) {
        int n = a.length;
        int m = b.length;
        int k = b[0].length;
        int[][] result = new int[n][k];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < k; y++) {
                int sum = 0;

                for (int z = 0; z < m; z++) {
                    sum += a[x][z] * b[z][y];
                }

                result[x][y] = sum;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}