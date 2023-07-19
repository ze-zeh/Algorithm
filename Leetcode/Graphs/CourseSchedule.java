class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> topo = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            list.get(prerequisite[0]).add(prerequisite[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                indegree[list.get(i).get(j)]++;
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            topo.add(cur);

            for (int v : list.get(cur)) {
                indegree[v]--;

                if (indegree[v] == 0) queue.add(v);
            }
        }

        return topo.size() == numCourses;
    }
}
