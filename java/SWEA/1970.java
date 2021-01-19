import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] divide = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            System.out.println("#" + tc);

            for (int i = 0; i < divide.length; i++) {
                int num = N / divide[i];
                N -= num * divide[i];
                System.out.print(num + " ");
            }
            System.out.println(' ');

        }
    }

}

