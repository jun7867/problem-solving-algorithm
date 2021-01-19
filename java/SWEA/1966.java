import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }
            Arrays.sort(array);

            System.out.print("#" + tc + " ");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println("");

        }
    }

}

