import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        int count = 0;
        boolean laser = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
                laser = true;
            } else {
                stack.pop();
                if (laser) {
                    count += stack.size();
                } else {
                    count++;
                }
                laser = false;
            }
        }

        System.out.println(count);
        br.close();
    }
}