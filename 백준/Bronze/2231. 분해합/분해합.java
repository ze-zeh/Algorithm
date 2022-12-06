import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int m = 1; m < n; m++) {
            int num = m + sum(m);
            if (num == n) {
                System.out.println(m);
                return;
            }
        }
        System.out.println(0);
    }

    public static int sum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
