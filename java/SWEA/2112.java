package SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_SWTEST_보호필름 {
	static int D, W, K;
	static int[][] map;
	static int[][] copy;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[D][W];
			copy = new int[D][W];
			min = D;

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = map[i][j];
				}
			}

			if (linear()) {
				System.out.println("#" + tc + " " + 0);
				continue;
			}

			recursion(0, 0);
			System.out.println("#" + tc + " " + min);
		}

	}

	private static boolean linear() {
		for (int j = 0; j < W; j++) {
			int count = 1;
			int prev = copy[0][j];
			int max = 0;
			for (int i = 1; i < D; i++) {
				if (prev == copy[i][j])
					count++;
				else
					count = 1;

				prev = copy[i][j];
				max = Math.max(max, count);
			}
			if (max < K)
				return false;
		}
		return true;
	}

	private static void recursion(int cnt, int idx) {

		// 기저 조건 (백트랙킹)
		if (cnt >= min)
			return;

		if (idx == D) {
			if (linear())
				min = Math.min(min, cnt);

			return;
		}

		// 아무것도 안넣기
		recursion(cnt, idx + 1);

		// A넣기
		for (int i = 0; i < W; i++) {
			copy[idx][i] = 0;
		}
		recursion(cnt + 1, idx + 1);

		// B넣기
		for (int i = 0; i < W; i++) {
			copy[idx][i] = 1;
		}
		recursion(cnt + 1, idx + 1);

		// 되돌리기
		for (int i = 0; i < W; i++) {
			copy[idx][i] = map[idx][i];
		}
	}

}

