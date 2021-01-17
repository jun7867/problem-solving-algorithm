import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            // 가로 체크
            int count = 0;
            for (int i = 0; i < N; i++) {
                int con = 0;
                for (int j = 0; j < N; j++) {
                    int num = map[i][j];
                    if (num == 1) {
                        con++;
                    }
                    if (j < N - 1 && map[i][j + 1] == 0) {
                        if (con == K) {
                            count++;
                        }
                        con = 0;
                    }
                }

                if (con == K) {
                    count++;
                }

            }
            // 세로 체크
            for (int i = 0; i < N; i++) {
                int con = 0;
                for (int j = 0; j < N; j++) {
                    int num = map[j][i];
                    if (num == 1) {
                        con++;
                    }
                    if (j < N - 1 && map[j + 1][i] == 0) {
                        if (con == K) {
                            count++;
                        }
                        con = 0;
                    }
                }

                if (con == K) {
                    count++;
                }
            }
            System.out.println("#" + t + " " + count);
        }
    }
}

