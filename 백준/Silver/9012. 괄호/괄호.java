import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<Boolean> stack = new Stack<>();
            String str = br.readLine();
            Boolean flag = false;
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '(') {
                    stack.push(true);
                } else if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    flag = true;
                    bw.write("NO\n");
                    break;
                }
            }
            if(flag) {
                continue;
            }

            if(stack.isEmpty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}