import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] classes = new int[n][5];
        boolean[][] students = new boolean[n][n];
        int answer = 0;
        int max = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                classes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < n; k++) {
                    if (classes[i][j] == classes[k][j]) {
                        students[i][k] = true;
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (students[i][j]) count++;
            }
            if (count > max) {
                max = count;
                answer = i + 1;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
