package SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// dfs + 시뮬 
public class BOJ_G2_19236_청소년상어 {
	static class Fish {
		int r, c, n, d;
		boolean alive;

		public Fish(int r, int c, int n, int d, boolean alive) {
			super();
			this.r = r;
			this.c = c;
			this.n = n;
			this.d = d;
			this.alive = alive;
		}

	}

	static int[][] map;
	static Fish[] fish;
	static int max = 0;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[4][4];
		fish = new Fish[17];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 4; j++) {
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken()) - 1;
				fish[n] = new Fish(i, j, n, d, true);
				map[i][j] = n;
			}
		}

		int sr = 0, sc = 0; // 상어 위치
		int sd = fish[map[0][0]].d; // 상어 초기 방향
		int eatSum = map[0][0];
		fish[map[0][0]].alive = false;
		map[0][0] = -1; // 상어가 있는 위치 -1

		dfs(sr, sc, sd, eatSum);
		System.out.println(max);
	}

	private static void dfs(int sr, int sc, int sd, int eatSum) {
		max = Math.max(max, eatSum);

		int[][] newMap = new int[4][4];
		for (int i = 0; i < 4; i++)
			System.arraycopy(map[i], 0, newMap[i], 0, 4);

		Fish[] newFish = new Fish[17];
		for (int i = 1; i <= 16; i++) {
			newFish[i] = new Fish(fish[i].r, fish[i].c, fish[i].n, fish[i].d, fish[i].alive);
		}

		moveFish();

		// 상어는 최대 3번 경우의 수
		for (int i = 1; i < 4; i++) {
			int nr = sr + dr[sd] * i;
			int nc = sc + dc[sd] * i;

			if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && map[nr][nc] != 0) {
				int eatFish = map[nr][nc];
				int nd = fish[eatFish].d;
				map[sr][sc] = 0;
				map[nr][nc] = -1;
				fish[eatFish].alive = false;

				dfs(nr, nc, nd, eatSum + eatFish);

				// 되돌리기
				fish[eatFish].alive = true;
				map[sr][sc] = -1;
				map[nr][nc] = eatFish;
			}
		}

		// 되돌리기 update
		map=newMap;
		fish=newFish;
//		for (int i = 0; i < 4; i++)
//			System.arraycopy(newMap[i], 0, map[i], 0, 4);
//		for (int i = 1; i <= 16; i++) {
//			fish[i] = new Fish(newFish[i].r, newFish[i].c, newFish[i].n, newFish[i].d, newFish[i].alive);
//		}
	}

	private static void moveFish() {
		for (int i = 1; i <= 16; i++) {
			if (!fish[i].alive) // 죽었으면 pass
				continue;

			int cnt = 0;
			int dir = fish[i].d;

			while (cnt < 8) {
				dir %= 8; // 방향이 0~7 반복
				fish[i].d = dir;

				int nr = fish[i].r + dr[dir];
				int nc = fish[i].c + dc[dir];

				if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && map[nr][nc] != -1) {
					if (map[nr][nc] == 0) { // 빈칸이라 이동 가능하면 물고기 이동
						map[fish[i].r][fish[i].c] = 0;
						fish[i].r = nr;
						fish[i].c = nc;
						map[nr][nc] = i;
					} else { // 다른 물고기와 교체
						int changeFish = fish[map[nr][nc]].n;
						fish[changeFish].r = fish[i].r;
						fish[changeFish].c = fish[i].c;
						map[fish[i].r][fish[i].c] = changeFish; // 바뀐 물고기로 변경

						fish[i].r = nr;
						fish[i].c = nc;
						map[nr][nc] = i; // 현재 물고기 변경
					}
					break; // 방향 변경 없이도 이동 완료
				} else { // 방향 변경 필요
					dir++;
					cnt++;
				}
			}

		}

	}

}

