package SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 중복 순열
public class SWEA_SWTEST_벽돌꺠기 {
	static class Node {
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int N, W, H;
	static int[][] map;
	static int[] pick;
	static int max = 0;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt = 0, total = 0;
	static Queue<Node> q;

	// 구슬 놓는 위치 순열
	private static void permutation(int idx) {
		if (idx == N) {
			int[][] copyMap = copy();
			getRemove(copyMap);

			return;
		}

		for (int i = 0; i < W; i++) {
			pick[idx] = i;
			permutation(idx + 1);
		}

	}

	// 지운 벽돌의 수
	private static void getRemove(int[][] map2) {
		cnt = 0; // 제거 블록 초기화
		// 순열만큼 반복
		for (int pickNo : pick) {
			visit = new boolean[H][W];

			for (int i = 0; i < H; i++) {
				if (map2[i][pickNo] != 0) {
					q.add(new Node(i, pickNo));
					visit[i][pickNo] = true;
					break;
				}
			}

			while (!q.isEmpty()) {
				Node cur = q.poll();
				int power = map2[cur.r][cur.c];
				map2[cur.r][cur.c] = 0;
				cnt++;

				if (power == 1)
					continue;

				for (int i = 0; i < 4; i++) {
					for (int p = 0; p < power; p++) {
						int nr = cur.r + dr[i] * p;
						int nc = cur.c + dc[i] * p;

						if (nr >= 0 && nr < H && nc >= 0 && nc < W && !visit[nr][nc] && map2[nr][nc] != 0) {
							visit[nr][nc] = true;
							q.add(new Node(nr, nc));
						}
					}
				}
			}
			refactoring(map2);
		}
		max = Math.max(max, cnt);

	}

	// 빈자리 밑으로 내리기
	private static void refactoring(int[][] map2) {
		for (int c = 0; c < W; c++) {
			for (int r = H - 1; r >= 0; r--) {
				if (map2[r][c] == 0) {
					int nr = r;

					while (nr > 0 && map2[nr][c] == 0) {
						nr--;
					}

					map2[r][c] = map2[nr][c];
					map2[nr][c] = 0;
				}
			}
		}
	}

	private static int[][] copy() {
		int[][] copyMap = new int[H][W];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copyMap[i][j] = map[i][j];
			}
		}

		return copyMap;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			pick = new int[N];
			q = new LinkedList<Node>();
			total = 0;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0)
						total++;
				}
			}
			max = 0;
			permutation(0);
			sb.append("#" + tc + " " + (total - max) + "\n");

		}
		System.out.println(sb.toString());
	}
}

