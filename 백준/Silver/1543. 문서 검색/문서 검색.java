import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        int answer = 0;

        A = A.replace(B, "0");

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '0') {
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}