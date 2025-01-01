import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tm = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    tm.put(n, tm.getOrDefault(n, 0) + 1);
                } else {
                    if (tm.size() > 0) {
                        int num = (n == 1) ? tm.lastKey() : tm.firstKey();
                        tm.put(num, tm.get(num) - 1);

                        if (tm.get(num) == 0) {
                            tm.remove(num);
                        }
                    }
                }
            }

            System.out.println(tm.size() == 0 ? "EMPTY" : tm.lastKey() + " " + tm.firstKey());
        }

        br.close();
    }
}