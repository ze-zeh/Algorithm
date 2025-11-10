import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer sounds = new StringTokenizer(br.readLine());
            StringTokenizer st;
            HashSet<String> hs = new HashSet<>();
            StringBuilder answer = new StringBuilder();

            while (true) {
                String str = br.readLine();

                if (str.equals("what does the fox say?")) {
                    break;
                }

                st = new StringTokenizer(str);

                st.nextToken();
                st.nextToken();

                hs.add(st.nextToken());
            }

            while (sounds.hasMoreTokens()) {
                String sound = sounds.nextToken();

                if (!hs.contains(sound)) {
                    if (answer.toString().equals("")) {
                        answer.append(sound);
                    } else {
                        answer.append(" " + sound);
                    }
                }
            }

            System.out.println(answer);
        }

        br.close();
    }
}
