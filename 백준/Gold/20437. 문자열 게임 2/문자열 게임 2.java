import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            playGame(W, K);
        }

        br.close();
    }

    public static void playGame(String W, int K) {
        List<List<Integer>> list = new ArrayList<>();
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < W.length(); i++) {
            list.get(W.charAt(i) - 'a').add(i);
        }

        if (!check(list, K)) {
            System.out.println(-1);
            return;
        }

        for (List<Integer> l : list) {
            if (l.size() < K) {
                continue;
            }

            for (int i = 0; i < l.size() - K + 1; i++) {
                int length = l.get(i + K - 1) - l.get(i) + 1;

                min = Math.min(min, length);
                max = Math.max(max, length);
            }
        }

        System.out.println(min + " " + max);
    }

    public static boolean check(List<List<Integer>> list, int K) {
        for (List<Integer> l : list) {
            if (l.size() >= K) {
                return true;
            }
        }

        return false;
    }
}
