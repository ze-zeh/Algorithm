import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        System.out.println(rev(rev(x) + rev(y)));
        br.close();
    }

    static public int rev(int n) {
        String str = Integer.toString(n);
        char[] arr = str.toCharArray();
        char[] reveredArr = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reveredArr[i] = arr[arr.length - 1 - i];
        }

        return Integer.parseInt(new String(reveredArr));
    }
}
