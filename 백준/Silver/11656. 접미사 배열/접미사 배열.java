import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            list.add(S.substring(i));
        }

        Collections.sort(list);

        for (String str : list) {
            sb.append(str + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}