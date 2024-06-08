import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[26];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                arr[c - 'A'] += pow(str.length() - j);
            }
        }

        Arrays.sort(arr);

        for (int i = 0; i <= 9; i++) {
            answer += arr[25 - i] * (9 - i);
        }

        System.out.println(answer);
        br.close();
    }

    static public int pow(int n) {
        if (n == 1) return 1;
        else return pow(n - 1) * 10;
    }
}
