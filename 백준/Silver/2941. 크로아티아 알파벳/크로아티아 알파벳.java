import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String[] arr = {"c=" , "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String s : arr) {
            A = A.replace(s, "0");
        }
        
        System.out.println(A.length());
        br.close();
    }
}