class Solution {
  public String solution(int n) {
      String[] numbers = {"4", "1", "2"};
      String answer = "";
      
      while (n > 0) {
          int r = n % 3;
          n /= 3;
          
          if (r == 0) n--;
          
          answer = numbers[r] + answer;
      }
      
      return answer;
  }
}