import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] tri = new int[N][N];
            tri[0][0] = 1;
            for (int i = 1; i < N; i++) {
                tri[i][0] = 1;
                for (int j = 1; j <= i - 1; j++) {
                    tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j];
                }
                tri[i][i] = 1;
            }
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i + 1; j++) {
                    System.out.print(tri[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }
}

