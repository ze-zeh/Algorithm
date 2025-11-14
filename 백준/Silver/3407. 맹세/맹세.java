import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
    static String[] elements = {
            "h", "he", "li", "be", "b", "c", "n", "o", "f", "ne", "na", "mg", "al", "si", "p", "s", "cl", "ar",
            "k", "ca", "sc", "ti", "v", "cr", "mn", "fe", "co", "ni", "cu", "zn", "ga", "ge", "as", "se", "br", "kr",
            "rb", "sr", "y", "zr", "nb", "mo", "tc", "ru", "rh", "pd", "ag", "cd", "in", "sn", "sb", "te", "i", "xe",
            "cs", "ba", "hf", "ta", "w", "re", "os", "ir", "pt", "au", "hg", "tl", "pb", "bi", "po", "at", "rn",
            "fr", "ra", "rf", "db", "sg", "bh", "hs", "mt", "ds", "rg", "cn", "fl", "lv",
            "la", "ce", "pr", "nd", "pm", "sm", "eu", "gd", "tb", "dy", "ho", "er", "tm", "yb", "lu",
            "ac", "th", "pa", "u", "np", "pu", "am", "cm", "bk", "cf", "es", "fm", "md", "no", "lr"
    };

    static HashSet<String> hs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        hs = new HashSet<>();

        for (String element : elements) {
            hs.add(element);
        }

        for (int i = 0; i < T; i++) {
            String word = br.readLine();
            System.out.println(checkWord(word) ? "YES" : "NO");
        }

        br.close();
    }

    private static boolean checkWord(String word) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = word.length();
        boolean[][] isChecked = new boolean[n][2];

        pq.add(0);

        while (!pq.isEmpty()) {
            if (pq.peek() >= n) {
                break;
            }

            int cur = pq.poll();

            if (!isChecked[cur][0] && cur + 1 <= n) {
                isChecked[cur][0] = hs.contains(word.substring(cur, cur + 1));

                if (isChecked[cur][0]) {
                    pq.add(cur + 1);
                }
            }

            if (!isChecked[cur][1] && cur + 2 <= n) {
                isChecked[cur][1] = hs.contains(word.substring(cur, cur + 2));

                if (isChecked[cur][1]) {
                    pq.add(cur + 2);
                }
            }
        }

        return isChecked[n - 1][0] || isChecked[n - 2][1];
    }
}