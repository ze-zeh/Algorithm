import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();

        A = A.replace("c=", "0");
        A = A.replace("c-", "0");
        A = A.replace("dz=", "0");
        A = A.replace("d-", "0");
        A = A.replace("lj", "0");
        A = A.replace("nj", "0");
        A = A.replace("s=", "0");
        A = A.replace("z=", "0");

        System.out.println(A.length());
        br.close();
    }
}