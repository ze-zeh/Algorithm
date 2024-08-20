import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();

            if (set.contains(name)) {
                list.add(name);
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for (String name : list) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
