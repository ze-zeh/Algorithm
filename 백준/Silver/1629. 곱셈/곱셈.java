import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.print(pow(a,b,c));
        br.close();
    }

    public static long pow(long a, long b, long c) {
        if(b==1) return a % c;
        long val = pow(a,b/2,c);
        val = val * val % c;
        if(b%2 == 0) return val;
        return val * a % c;
    }
}