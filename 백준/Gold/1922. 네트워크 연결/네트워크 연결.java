import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int Answer;
	static int[] P;
	static PriorityQueue<Edge> Pq;

	public static class Edge {
		int start;
		int end;
		int cost;

		Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		Answer = 0;
		Pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		P = new int[N];

		for (int i = 0; i < N; i++) {
			P[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());

			Pq.add(new Edge(a, b, c));
		}

		while (!Pq.isEmpty()) {
			Edge cur = Pq.poll();

			if (union(cur.start, cur.end)) {
				Answer += cur.cost;
			}
		}

		System.out.println(Answer);

		br.close();
	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			return false;
		}

		if (x > y) {
			P[x] = y;
		} else {
			P[y] = x;
		}

		return true;
	}

	public static int find(int x) {
		if (x == P[x]) {
			return x;
		}

		P[x] = find(P[x]);

		return P[x];
	}
}
