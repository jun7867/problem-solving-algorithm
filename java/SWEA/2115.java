package SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 완탐(조합+부분집합) + 시뮬
public class SWEA_SWTEST_벌꿀채취 {
	static int N, M, C;
	static int[][] map;
	static int[][] profitMax;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			ans = 0;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			profitMax = new int[N][N];
			profit();
			process();
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb.toString());

	}

	// 모든 벌꿀채취 부분집합에 대한 max profit
	private static void profit() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				// idx, r, c, quantity , profit
				subset(0, i, j, 0, 0);
			}
		}
	}

	private static void subset(int idx, int r, int c, int q, int p) {
		// 전체 추출을 초과
		if (q > C) {
			return;
		}
		// M개까지 추출
		if (idx == M) {
			profitMax[r][c - M] = Math.max(profitMax[r][c - M], p);
			return;
		}

		// 선택 O
		int honey = map[r][c];
		subset(idx + 1, r, c + 1, q + honey, p + honey * honey);
		// 선택 X
		subset(idx + 1, r, c + 1, q, p);
	}

	private static void process() {
		// 일꾼 A의 조합
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				Bcombi(i, j, 1, profitMax[i][j]);
			}
		}
	}

	private static void Bcombi(int ar, int ac, int idx, int profit) {
		if (idx == 2) { // A는 이미 채취했고 B의 조합만 구하면
			ans = Math.max(ans, profit);
			return;
		}

		// 일꾼 A에 맞춘 일꾼 b의 조합
		for (int i = ar; i < N; i++) {
			for (int j = ac + M; j <= N - M; j++) {
				Bcombi(i, j, idx + 1, profit + profitMax[i][j]);
			}
			ac = -M; // 다음줄은 0부터 검사해야함
		}
	}
}

