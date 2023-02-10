import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        boolean flag = false;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if(ch == ' ' && !flag) {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                result.append(" ");
                continue;
            }

            if (ch == '<') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                flag = true;
                result.append(ch);
                continue;
            }
            if (ch == '>') {
                flag = false;
                result.append(ch);
                continue;
            }
            if (flag) {
                result.append(ch);
                continue;
            }

            stack.add(ch);
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.print(result);
        br.close();
    }
}
