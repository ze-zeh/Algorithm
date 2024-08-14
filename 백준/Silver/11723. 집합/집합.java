import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int bit = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "add": {
                    bit |= (1 << Integer.parseInt(st.nextToken()));
                    break;
                }
                case "remove": {
                    bit &= ~(1 << Integer.parseInt(st.nextToken()));
                    break;
                }
                case "check": {
                    if (0 < (1 << Integer.parseInt(st.nextToken()) & bit)) {
                        bw.append(1 + "\n");
                    } else {
                        bw.append(0 + "\n");
                    }
                    break;
                }
                case "toggle": {
                    int x = Integer.parseInt(st.nextToken());

                    if (0 < (1 << x & bit)) {
                        bit &= ~(1 << x);
                    } else {
                        bit |= (1 << x);
                    }
                    break;
                }
                case "all": {
                    bit |= (1 << 21) - 1;
                    break;
                }
                case "empty": {
                    bit = 0;
                    break;
                }
            }
        }
        
        bw.flush();
        br.close();
    }
}
