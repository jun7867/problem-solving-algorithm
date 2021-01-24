package D2;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			int value = 0;
			for (int i = 0; i < (int) Math.ceil((double) N / 2); i++) {
				// 위에 가로
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						map[i][j] = ++value;
						visited[i][j] = true;
					}
				}
				// 오른쪽 세로
				for (int j = 1; j < N; j++) {
					if (!visited[j][N - i - 1]) {
						map[j][N - i - 1] = ++value;
						visited[j][N - i - 1] = true;
					}
				}

				// 아래 가로
				for (int j = 1; j < N; j++) {
					if (!visited[N - 1 - i][N - 1 - j]) {
						map[N - 1 - i][N - 1 - j] = ++value;
						visited[N - 1 - i][N - 1 - j] = true;
					}
				}

				// 왼쪽 세로
				for (int j = 1; j < N; j++) {
					if (!visited[N - j - 1][i]) {
						map[N - j - 1][i] = ++value;
						visited[N - j - 1][i] = true;
					}
				}
			}
			System.out.printf("#%d\n", tc);
			for (int k = 0; k < N; k++) {
				for (int p = 0; p < N; p++) {
					System.out.print(map[k][p] + " ");
				}
				System.out.println("");
			}
		}

	}

}

