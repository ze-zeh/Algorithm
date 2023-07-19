class Solution {
    static boolean[] visited;
    static Map<Integer, List<Integer>> map;

    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        int[] result = new int[2];
        map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            visited = new boolean[N + 1];

            if (!map.get(edge[0]).isEmpty() &&
                    !map.get(edge[1]).isEmpty() &&
                    dfsFindRedundantConnection(edge[0], edge[1])) {
                return edge;
            }

            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        return result;
    }

    public boolean dfsFindRedundantConnection(int a, int b) {
        if (a == b) return true;

        visited[a] = true;

        for (int i : map.get(a)) {
            if (visited[i]) continue;
            if (dfsFindRedundantConnection(i, b)) return true;
        }

        return false;
    }
}