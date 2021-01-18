import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            boolean isFail = false;
            int[][] map = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            // 가로 체크
            for (int i = 0; i < 9; i++) {
                int sum = 0;
                for (int j = 0; j < 9; j++) {
                    sum += map[i][j];
                }
                if (sum != 45) {
                    isFail = true;
                    break;
                }
            }

            // 세로 체크
            for (int i = 0; i < 9; i++) {
                int sum = 0;
                for (int j = 0; j < 9; j++) {
                    sum += map[j][i];
                }
                if (sum != 45) {
                    isFail = true;
                    break;
                }
            }
            // 사각형 체크
            for (int k = 0; k < 9; k++) {
                int sum = 0;
                for (int i = 0 + (k / 3) * 3; i < 3 + (k / 3) * 3; i++) {
                    for (int j = 0 + (k * 3) % 9; j < 3 + (k * 3) % 9; j++) {
                        sum += map[i][j];
                    }
                }
                if (sum != 45) {
                    isFail = true;
                    break;
                }
            }
            // 5555555 방지
            if (map[0][0] == map[0][1]) {
                isFail = true;
            }

            if (isFail) {
                System.out.println("#" + t + " 0");
            } else {
                System.out.println("#" + t + " 1");
            }

        }
    }
}

