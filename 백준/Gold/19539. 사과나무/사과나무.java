import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int odd = 0;
        int even = 0;

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            odd += height % 2;
            even += height / 2;
            sum += height;
        }

        if (sum % 3 != 0) {
            System.out.println("NO");
            return;
        }

        if (odd > even) {
            System.out.println("NO");
        } else if (odd == even) {
            System.out.println("YES");
        } else {
            if ((even - odd) % 3 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        br.close();
    }
}
