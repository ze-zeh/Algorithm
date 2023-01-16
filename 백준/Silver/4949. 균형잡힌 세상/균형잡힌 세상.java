import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            boolean isValid = true;
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();

            if (str.equals(".")) {
                break;
            }

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                switch (ch) {
                    case '(':
                    case '[': {
                        stack.push(ch);
                        break;
                    }
                    case ')': {
                        if (stack.isEmpty() || stack.peek() != '(') {
                            isValid = false;
                            break;
                        }
                        stack.pop();
                        break;
                    }
                    case ']': {
                        if (stack.isEmpty() || stack.peek() != '[') {
                            isValid = false;
                            break;
                        }
                        stack.pop();
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) isValid = false;

            if (isValid) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}