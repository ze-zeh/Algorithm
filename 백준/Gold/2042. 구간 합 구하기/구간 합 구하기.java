import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static long[] Arr;

	public static class SegmentTree {
		long[] tree;

		SegmentTree(int n) {
			int height = (int) (Math.ceil(Math.log(n) / Math.log(2)) + 1);
			int size = (int) Math.pow(2, height);
			tree = new long[size];
		}

		public void init(int node, int start, int end) {
			if (start == end) {
				tree[node] = Arr[start];
				return;
			}

			int mid = (start + end) / 2;

			init(node * 2, start, mid);
			init(node * 2 + 1, mid + 1, end);

			tree[node] = tree[node * 2] + tree[node * 2 + 1];
		}

		public long getSum(int node, int start, int end, int left, int right) {
			if (right < start || end < left) {
				return 0;
			}

			if (left <= start && end <= right) {
				return tree[node];
			}

			int mid = (start + end) / 2;
			long leftSum = getSum(node * 2, start, mid, left, right);
			long rightSum = getSum(node * 2 + 1, mid + 1, end, left, right);
			return leftSum + rightSum;
		}

		public void update(int node, int start, int end, int index, long value) {
			if (start == end) {
				tree[node] = value;
				return;
			}

			int mid = (start + end) / 2;

			if (index <= mid) {
				update(node * 2, start, mid, index, value);
			} else {
				update(node * 2 + 1, mid + 1, end, index, value);
			}

			tree[node] = tree[node * 2] + tree[node * 2 + 1];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arr = new long[N];
		SegmentTree s = new SegmentTree(N);

		for (int i = 0; i < N; i++) {
			Arr[i] = Long.parseLong(br.readLine());
		}

		s.init(1, 0, N - 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				s.update(1, 0, N - 1, b - 1, c);
			} else {
				System.out.println(s.getSum(1, 0, N - 1, b - 1, (int) c - 1));
			}
		}

		br.close();
	}
}
