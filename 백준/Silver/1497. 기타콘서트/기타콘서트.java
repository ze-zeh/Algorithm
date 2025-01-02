import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static long Answer = Integer.MAX_VALUE;
    static long Max = 0;
    static int N;
    static int M;
    static long[] Arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Arr = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String s = st.nextToken();

            s = s.replace('Y', '1');
            s = s.replace('N', '0');
            Arr[i] = Long.parseLong(s, 2);
        }

        backtracking(0L, 0, 0);
        System.out.println((Answer != 0) ? Answer : -1);
        br.close();
    }

    public static void backtracking(long bit, int idx, int size) {
        int bitCount = Long.bitCount(bit);

        if (bitCount > Max) {
            Answer = size;
            Max = bitCount;
        } else if (bitCount == Max && size < Answer) {
            Answer = size;
        }

        if (bitCount == M || idx == N) {
            return;
        }

        backtracking(bit, idx + 1, size);
        backtracking(bit | Arr[idx], idx + 1, size + 1);
    }
}