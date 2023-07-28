class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    int N;
    int M;
    int[][] Heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Heights = heights;
        N = heights.length;
        M = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] pacificVisited = new boolean[N][M];
        boolean[][] atlanticVisited = new boolean[N][M];

        for (int i = 0; i < M; i++) {
            dfsPacificAtlantic(0, i, -1, pacificVisited);
            dfsPacificAtlantic(N - 1, i, -1, atlanticVisited);
        }

        for (int i = 0; i < N; i++) {
            dfsPacificAtlantic(i, 0, -1, pacificVisited);
            dfsPacificAtlantic(i, M - 1, -1, atlanticVisited);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);

                    result.add(list);
                }
            }
        }

        return result;
    }

    public void dfsPacificAtlantic(int x, int y, int prev, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y] || Heights[x][y] < prev) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            dfsPacificAtlantic(x + dx[i], y + dy[i], Heights[x][y], visited);
        }
    }
}
