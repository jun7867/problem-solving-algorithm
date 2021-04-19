package SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S1_20055_컨베이어벨트위의로봇 {
	static int N, K;
	static int[][] map;
	static boolean[] robot;
	static int zeroCnt = 0;
	static int level = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[2][N];
		robot = new boolean[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			map[0][i] = Integer.parseInt(st.nextToken());
		}

		for (int i = N - 1; i >= 0; i--) {
			map[1][i] = Integer.parseInt(st.nextToken());
		}

		while (true) {
			rotate();
			move();
			put();
			zeroCheck();
			if (zeroCnt >= K)
				break;
			level++;
		}

		System.out.println(level);

	}

	private static void zeroCheck() {
		zeroCnt = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] <= 0)
					zeroCnt++;
			}
		}

	}

	private static void put() {
		if (!robot[0] && map[0][0] > 0) {
			robot[0] = true;
			map[0][0]--;
		}
	}

	private static void move() {
		for (int i = N - 2; i >= 0; i--) {
			// 다음 벨트로 로봇이 이동할 수 있다면 이동
			if (robot[i] && !robot[i + 1] && map[0][i + 1] > 0) {
				robot[i + 1] = true;
				robot[i] = false;
				map[0][i + 1]--;
			}
		}

	}

	private static void rotate() {
		int[][] newMap = new int[N][N];

		int k = 1;
		for (int i = 0; i < N; i++) {
			if (i == N - 1)
				newMap[1][N - 1] = map[0][i];
			else
				newMap[0][k++] = map[0][i];
		}

		k = N - 2;
		for (int i = N - 1; i >= 0; i--) {
			if (i == 0)
				newMap[0][0] = map[1][i];
			else
				newMap[1][k--] = map[1][i];
		}

		// 로봇이 N-1로 가는 순간 떨어짐
		for (int i = N - 1; i > 0; i--) {
			robot[i] = robot[i - 1];
		}

		robot[0] = false;
		robot[N - 1] = false;

		map = newMap;
	}

}

