import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<String> list = new LinkedList<>(Arrays.asList(br.readLine().split("")));
        int m = Integer.parseInt(br.readLine());
        ListIterator<String> cursor = list.listIterator();

        while (cursor.hasNext()) {
            cursor.next();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            String add = "";
            if (st.countTokens() == 1) {
                add = st.nextToken();
            }

            switch (command) {
                case "L":
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                    break;
                case "D":
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                    break;
                case "B":
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case "P":
                    cursor.add(add);
                    break;
            }
        }

        bw.write(String.join("", list));
        bw.flush();
        bw.close();
        br.close();
    }
}