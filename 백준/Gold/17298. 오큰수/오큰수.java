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
        int[] nge = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!stack.empty()) {
                if (stack.peek() >= num) {
                    break;
                }
                stack.pop();
                int idx = index.pop();
                nge[idx] = num;
            }

            stack.push(num);
            index.push(i);
        }

        while (!stack.empty()) {
            int idx = index.pop();
            stack.pop();
            nge[idx] = -1;
        }
        
        nge[nge.length - 1] = -1;

        for (int num : nge) {
            bw.write(num + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}