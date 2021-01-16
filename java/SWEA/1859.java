import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int c = 1; c <= T; c++) {
            int N = sc.nextInt();
            ArrayList<Integer> price = new ArrayList<>();
            long profit = 0;
            for (int j = 0; j < N; j++) {
                price.add(sc.nextInt());
            }
            int max = price.get(N - 1);
            for (int i = N - 1; i > 0; i--) {
                if (price.get(i - 1) < max) {
                    profit += max - price.get(i - 1);
                } else {
                    max = Math.max(price.get(i - 1), max);
                }
            }
            System.out.println("#" + c + " " + profit);
        }
    }
}
