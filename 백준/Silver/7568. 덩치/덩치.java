import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<Pair<Integer, Integer>> wh = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            wh.add(new Pair(input.nextInt(), input.nextInt()));
        }
        int[] result = new int[n];
        Arrays.fill(result, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (wh.get(i).getKey() < wh.get(j).getKey()
                            && wh.get(i).getValue() < wh.get(j).getValue()) {
                        result[i]++;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
