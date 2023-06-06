import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static class Node {
        HashMap<String, Node> children = new HashMap<>();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node root = new Node();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            Node cur = root;

            for (int j = 0; j < K; j++) {
                String str = st.nextToken();

                if (!cur.children.containsKey(str)) cur.children.put(str, new Node());
                cur = cur.children.get(str);
            }
        }

        dfs(root, 0);
    }

    public static void dfs(Node node, int barCount) {
        Object[] keys = node.children.keySet().toArray();
        Arrays.sort(keys);

        for (Object key : keys) {
            for (int i = 0; i < barCount; i++) System.out.print("--");
            System.out.println(key);

            dfs(node.children.get(key), barCount + 1);
        }
    }
}