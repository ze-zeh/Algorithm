import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < 7; i++) {
            if ((x & (1 << i)) > 0) {
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
