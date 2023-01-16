import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    private static final int TWO = 2;
    private static final int FIVE = 5;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int remain = n - i * TWO;
            if (remain % FIVE == 0) {
                System.out.println(remain / FIVE + i);
                return;
            }
        }

        System.out.println("-1");
    }
}