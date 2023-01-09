import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int e = 1;
        int s = 1;
        int m = 1;
        int year = 1;

        while (!(E == e && S == s && M == m)) {
            year++;
            e++;
            s++;
            m++;
            if (e > 15) e %= 15;
            if (s > 28) s %= 28;
            if (m > 19) m %= 19;
        }

        bw.write(String.valueOf(year));
        bw.flush();
        bw.close();
        br.close();
    }
}