import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();

		System.out.println(kmp(S, P));

		br.close();
	}

	public static int kmp(String S, String P) {
		int[] lps = new int[P.length()];
		int j = 0;

		for (int i = 1; i < P.length(); i++) {
			while (j > 0 && P.charAt(i) != P.charAt(j)) {
				j = lps[j - 1];
			}

			if (P.charAt(i) == P.charAt(j)) {
				j++;
				lps[i] = j;
			}
		}

		j = 0;

		for (int i = 0; i < S.length(); i++) {
			while (j > 0 && S.charAt(i) != P.charAt(j)) {
				j = lps[j - 1];
			}

			if (S.charAt(i) == P.charAt(j)) {
				j++;
			}

			if (j == P.length()) {
				return 1;
			}
		}

		return 0;
	}
}