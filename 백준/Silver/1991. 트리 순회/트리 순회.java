import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static Node[] tree;

    static class Node {
        char data;
        int left;
        int right;

        Node(char data, int left, int right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            char data = st.nextToken().charAt(0);
            int node = data - 'A';
            int left = st.nextToken().charAt(0);
            int right = st.nextToken().charAt(0);

            if (left == '.') {
                left = -1;
            } else {
                left = left - 'A';
            }

            if (right == '.') {
                right = -1;
            } else {
                right = right - 'A';
            }

            tree[node] = new Node(data, left, right);
        }

        System.out.println(preorderTraversal(tree[0]));
        System.out.println(inorderTraversal(tree[0]));
        System.out.println(postorderTraversal(tree[0]));

        br.close();
    }

    static String preorderTraversal(Node node) {
        String result = "";

        result += node.data;

        if (node.left != -1)
            result += preorderTraversal(tree[node.left]);

        if (node.right != -1)
            result += preorderTraversal(tree[node.right]);

        return result;
    }

    static String inorderTraversal(Node node) {
        String result = "";

        if (node.left != -1)
            result += inorderTraversal(tree[node.left]);

        result += node.data;

        if (node.right != -1)
            result += inorderTraversal(tree[node.right]);

        return result;
    }

    static String postorderTraversal(Node node) {
        String result = "";

        if (node.left != -1)
            result += postorderTraversal(tree[node.left]);

        if (node.right != -1)
            result += postorderTraversal(tree[node.right]);

        result += node.data;

        return result;
    }
}
