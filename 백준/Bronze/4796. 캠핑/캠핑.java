import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i = 0;
        while (true) {
            int l = input.nextInt();
            int p = input.nextInt();
            int v = input.nextInt();
            int result = 0;
            if (l == 0 && p == 0 && v == 0) break;

            result += v / p * l;
            v %= p;
            if(v > l) {
                result += l;
            } else {
                result += v;
            }
            System.out.println("Case " + ++i + ": " + result);
        }
    }
}
