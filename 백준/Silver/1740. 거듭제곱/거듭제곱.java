import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long answer = 0L;
        long num = 1L;

        while (n > 0) {
            if ((n & 1) == 1) {
                answer += num;
            }

            num *= 3;
            n >>= 1;
        }

        System.out.println(answer);
        br.close();
    }
}