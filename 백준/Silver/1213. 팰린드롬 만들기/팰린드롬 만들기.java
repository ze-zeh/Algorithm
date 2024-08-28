import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[26];
        StringBuilder sb = new StringBuilder();
        char lastChar = '0';

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'A';
            arr[idx]++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 == 0) {
                int count = arr[i] / 2;

                while (count-- > 0) {
                    sb.append((char) ('A' + i));
                }
            } else {
                if (lastChar != '0') {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }

                int count = arr[i] / 2;
                lastChar = (char) ('A' + i);

                while (count-- > 0) {
                    sb.append((char) ('A' + i));
                }
            }
        }

        if (lastChar == '0') {
            System.out.println(sb.toString() + sb.reverse());
        } else {
            System.out.println(sb.toString() + lastChar + sb.reverse());
        }

        br.close();
    }
}