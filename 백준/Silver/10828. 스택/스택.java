import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = -1;
            if (st.countTokens() == 1) {
                num = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "push":
                    stack.push(num);
                    break;
                case "pop":
                    if (stack.empty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(stack.pop() + "\n");
                    }
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":
                    if (stack.empty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "top":
                    if (stack.empty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(stack.peek() + "\n");
                    }
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}