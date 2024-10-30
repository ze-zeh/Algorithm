class Solution {
    public static int Answer = 0;
    public static int[] Numbers;
    public static int Target;
    
    public int solution(int[] numbers, int target) {
        Numbers = numbers;
        Target = target;
        
        dfs(0, 0);
        
        return Answer;
    }
    
    public void dfs(int n, int depth) {
        if (depth == Numbers.length) {
            if (Target == n) {
                Answer++;
            }
            return;
        }
        
        dfs(n + Numbers[depth], depth + 1);
        dfs(n - Numbers[depth], depth + 1);
    }
}