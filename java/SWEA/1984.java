import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int max = 0;
            int min = 10000;
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                int N = sc.nextInt();
                if (N > max) {
                    max = N;
                }
                if (N < min) {
                    min = N;
                }
                sum += N;
            }
            sum = sum - max - min;

            System.out.println("#" + t + " " + Math.round((double)sum / 8));

        }
    }
}

