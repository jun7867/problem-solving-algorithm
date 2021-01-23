import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] map = new char[N][M];
        int row = 0;
        int col = 0;
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        // 행 체크
        for (int i = 0; i < N; i++) {
            boolean isX = false;
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'X') {
                    isX = true;
                    break;
                }
            }
            if (!isX) {
                row++;
            }
        }
        // 열체크
        for (int i = 0; i < M; i++) {
            boolean isX = false;
            for (int j = 0; j < N; j++) {
                if (map[j][i] == 'X') {
                    isX = true;
                    break;
                }
            }
            if (!isX) {
                col++;
            }
        }

        System.out.println(Math.max(row, col));

    }
}

