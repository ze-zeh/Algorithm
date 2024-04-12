import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n / 3; i++) {
            int num = n - i * 3;

            if (num % 5 == 0) {
                System.out.print(num / 5 + i);
                return;
            }
        }

        System.out.print(-1);
        br.close();
    }
}
