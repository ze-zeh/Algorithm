class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        int count = 0;
        int result = 0;
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) max++;
                if (grid[i][j] == 2) queue.add(new Pair(i, j));
            }
        }

        while (!queue.isEmpty() && count < max) {
            int size = queue.size();

            count += size;
            if (count == max) return result;

            result++;

            for (int i = 0; i < size; i++) {
                Pair cur = queue.peek();

                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 1) continue;

                    grid[nx][ny] = 2;
                    queue.add(new Pair(nx, ny));
                }

                queue.poll();
            }
        }

        if (max == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}

static class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}