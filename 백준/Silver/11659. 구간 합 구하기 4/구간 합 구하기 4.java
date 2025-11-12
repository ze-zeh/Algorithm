import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] prefix = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
		}

		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			System.out.println(prefix[j] - prefix[i - 1]);
		}

		br.close();
	}
}
