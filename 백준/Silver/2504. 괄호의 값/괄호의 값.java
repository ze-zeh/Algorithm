import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        int sum = 0;
        int num = 1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '(': {
                    num *= 2;
                    stack.push(ch);
                    break;
                }
                case '[': {
                    num *= 3;
                    stack.push(ch);
                    break;
                }
                case ')': {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        System.out.println(0);
                        return;
                    }

                    if (str.charAt(i - 1) == '(') sum += num;
                    stack.pop();
                    num /= 2;

                    break;
                }
                case ']': {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        System.out.println(0);
                        return;
                    }

                    if (str.charAt(i - 1) == '[') sum += num;
                    stack.pop();
                    num /= 3;

                    break;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println(sum);
        } else {
            System.out.println(0);
        }

        br.close();
    }
}