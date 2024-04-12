import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int length = n - k;
        Stack<Character> stack = new Stack<>();
        String num = br.readLine();

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            while (!stack.empty() && k > 0 && stack.peek() < ch) {
                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        while (stack.size() != length) {
            stack.pop();
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse());

        br.close();
    }
}
