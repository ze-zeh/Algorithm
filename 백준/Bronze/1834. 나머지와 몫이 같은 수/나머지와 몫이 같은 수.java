import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long answer = 0L;
        long i = 1L;

        while (i < n) {
            long num = i * n + i;
            answer += num;
            i++;
        }

        System.out.println(answer);
        br.close();
    }
}
