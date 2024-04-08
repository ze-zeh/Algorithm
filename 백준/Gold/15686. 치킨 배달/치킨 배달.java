import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;
    static int Answer;
    static ArrayList<Point> ChickenList;
    static ArrayList<Point> HomeList;

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Answer = Integer.MAX_VALUE;
        ChickenList = new ArrayList<>();
        HomeList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(st.nextToken());

                if (cur == 2) {
                    ChickenList.add(new Point(i, j));
                } else if (cur == 1) {
                    HomeList.add(new Point(i, j));
                }
            }
        }

        dfs(new ArrayList<>(), 0, 0);
        System.out.println(Answer);
        br.close();
    }

    private static void dfs(ArrayList<Point> chickList, int size, int i) {
        if (size == M) {
            calcDist(chickList);
            return;
        }

        if (i == ChickenList.size()) return;

        chickList.add(ChickenList.get(i));
        dfs(chickList, size + 1, i + 1);
        chickList.remove(ChickenList.get(i));
        dfs(chickList, size, i + 1);
    }

    private static void calcDist(ArrayList<Point> chickList) {
        int minSum = 0;

        for (Point h : HomeList) {
            int minDist = Integer.MAX_VALUE;

            for (Point c : chickList) {
                minDist = Math.min(Math.abs(c.x - h.x) + Math.abs(c.y - h.y), minDist);
            }

            minSum += minDist;
        }

        Answer = Math.min(minSum, Answer);
    }
}
