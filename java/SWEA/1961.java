import java.util.*;

public class Solution {
    static int[][] map;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int[][] rotation_90 = Rotation(map); // 90 degree rotation
            int[][] rotation_180 = Rotation(rotation_90); // 180 degree rotation
            int[][] rotation_270 = Rotation(rotation_180); // 270 degree rotation

            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(rotation_90[i][j]); // 90 degree rotated shape
                }
                System.out.print(" ");

                for (int j = 0; j < N; j++) {
                    System.out.print(rotation_180[i][j]); // 180 degree rotated shape
                }
                System.out.print(" ");

                for (int j = 0; j < N; j++) {
                    System.out.print(rotation_270[i][j]); // 270 degree rotated shape
                }
                System.out.println("");
            }
        }
    }

    // 90 degree rotation
    public static int[][] Rotation(int[][] map) {
        int[][] temp_map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp_map[i][j] = map[N - 1 - j][i];
            }
        }

        return temp_map;
    }
}

