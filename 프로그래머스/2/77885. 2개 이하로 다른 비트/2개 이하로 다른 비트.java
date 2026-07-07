class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            
            if (number % 2 == 0) {
                answer[i] = number + 1;
            } else {
                String bs = Long.toBinaryString(number);
                bs = bs.contains("0") ? bs : "0" + bs;

                int idx = bs.lastIndexOf('0');

                bs = bs.substring(0, idx) + "10" + bs.substring(idx + 2);
                answer[i] = Long.parseLong(bs, 2);
            }
        }
        
        return answer;
    }
}