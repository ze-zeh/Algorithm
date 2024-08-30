import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int minPackage = Integer.MAX_VALUE;
        int minUnit = Integer.MAX_VALUE;
        int min;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            minPackage = Math.min(minPackage, Integer.parseInt(st.nextToken()));
            minUnit = Math.min(minUnit, Integer.parseInt(st.nextToken()));
        }

        min = Math.min(((n / 6) + 1) * minPackage, n * minUnit);
        min = Math.min(min, (n / 6) * minPackage + (n % 6) * minUnit);
        System.out.println(min);
        br.close();
    }
}