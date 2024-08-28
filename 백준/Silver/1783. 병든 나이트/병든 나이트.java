import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer;

        if (n == 1) {
            answer = 1;
        } else if (n == 2) {
            answer = Math.min((m + 1) / 2, 4);
        } else {
            if (m >= 7) {
                answer = m - 2;
            } else {
                answer = Math.min(m, 4);
            }
        }

        System.out.println(answer);
        br.close();
    }
}