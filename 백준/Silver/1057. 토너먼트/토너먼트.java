import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int kjm = Integer.parseInt(st.nextToken());
        int ihs = Integer.parseInt(st.nextToken());

        while (kjm != ihs) {
            N /= 2;
            kjm = kjm / 2 + kjm % 2;
            ihs = ihs / 2 + ihs % 2;
            answer++;
        }

        System.out.println(answer);
        br.close();
    }
}