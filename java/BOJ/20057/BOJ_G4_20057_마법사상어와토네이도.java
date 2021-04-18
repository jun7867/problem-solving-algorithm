package SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_20057_마법사상어와토네이도 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int N;
	static int[][] map;
	static int nr, nc, r, c;
	static int[] dr = { 0, 1, 0, -1 }; // 좌하우상 (2번에 한번씩 반복횟수 1씩 증가)
	static int[] dc = { -1, 0, 1, 0 };
	static int sum = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		tonado(0,0,1,0,N/2,N/2);
		System.out.println(sum);

	}

	private static void tonado(int corner, int cnt, int size, int dir, int r, int c) {
		if(r==0 && c==0)
			return;
		
		int nr=r+dr[dir];
		int nc=c+dc[dir];
		
		wind(nr,nc,r,c,dir);
		cnt++;
		
		// 반복횟수만큼 갔으면 다음 방향으로 변경
		if(cnt==size) {
			corner++;
			dir++;
			dir %=4;
			cnt=0;
		}
		
		// 코너를 2번 돌때마다 반복횟수 1 증가
		if(corner==2) {
			corner=0;
			size++;
		}
		tonado(corner, cnt, size, dir, nr, nc);
		
	}

	private static void wind(int nr, int nc, int r, int c, int dir) {
		int now = map[nr][nc];
		int s1 = (int) (now * 0.01);
		int s2 = (int) (now * 0.02);
		int s5 = (int) (now * 0.05);
		int s7 = (int) (now * 0.07);
		int s10 = (int) (now * 0.1);
		int a = now - 2 * (s1 + s2 + s7 + s10) - s5;
		map[nr][nc] = 0;

		if (dir == 0 || dir == 2) {
			// 1% 원래 위치 +1 -1 상하(1,3)
			for (int i = 0; i < 2; i++) {
				int sr = r + dr[1 + 2 * i];
				int sc = c + dc[1 + 2 * i];
				if (rangeCheck(sr, sc))
					map[sr][sc] += s1;
				else
					sum += s1;
			}

			// 2% 토네이도 위치 +2 -2 상하(1,3)
			for (int i = 0; i < 2; i++) {
				int sr = nr + dr[1 + 2 * i] * 2;
				int sc = nc + dc[1 + 2 * i] * 2;
				if (rangeCheck(sr, sc))
					map[sr][sc] += s2;
				else
					sum += s2;
			}

			// 7% 토네이도 위치 +1 -1 상하(1,3)
			for (int i = 0; i < 2; i++) {
				int sr = nr + dr[1 + 2 * i];
				int sc = nc + dc[1 + 2 * i];
				if (rangeCheck(sr, sc))
					map[sr][sc] += s7;
				else
					sum += s7;
			}

			// 10% 토네이도 다음칸 +1 -1 상하(1,3)
			for (int i = 0; i < 2; i++) {
				int sr = nr + dr[dir] + dr[1 + 2 * i];
				int sc = nc + dc[dir] + dc[1 + 2 * i];
				if (rangeCheck(sr, sc))
					map[sr][sc] += s10;
				else
					sum += s10;
			}

			// 5%
			int sr = nr + dr[dir] * 2;
			int sc = nc + dc[dir] * 2;
			if (rangeCheck(sr, sc))
				map[sr][sc] += s5;
			else
				sum += s5;

			// a
			sr = nr + dr[dir];
			sc = nc + dc[dir];
			if (rangeCheck(sr, sc))
				map[sr][sc] += a;
			else
				sum += a;
		} else { // 방향 하 or 상
			// 1% 원래 위치 +1 -1 상하(1,3)
			for (int i = 0; i < 2; i++) {
				int sr = r + dr[2 * i];
				int sc = c + dc[2 * i];
				if (rangeCheck(sr, sc))
					map[sr][sc] += s1;
				else
					sum += s1;
			}

			// 2% 토네이도 위치 +2 -2 상하(1,3)
			for (int i = 0; i < 2; i++) {
				int sr = nr + dr[2 * i] * 2;
				int sc = nc + dc[2 * i] * 2;
				if (rangeCheck(sr, sc))
					map[sr][sc] += s2;
				else
					sum += s2;
			}

			// 7% 토네이도 위치 +1 -1 상하(1,3)
			for (int i = 0; i < 2; i++) {
				int sr = nr + dr[2 * i];
				int sc = nc + dc[2 * i];
				if (rangeCheck(sr, sc))
					map[sr][sc] += s7;
				else
					sum += s7;
			}

			// 10% 토네이도 다음칸 +1 -1 상하(1,3)
			for (int i = 0; i < 2; i++) {
				int sr = nr + dr[dir] + dr[2 * i];
				int sc = nc + dc[dir] + dc[2 * i];
				if (rangeCheck(sr, sc))
					map[sr][sc] += s10;
				else
					sum += s10;
			}

			// 5%
			int sr = nr + dr[dir] * 2;
			int sc = nc + dc[dir] * 2;
			if (rangeCheck(sr, sc))
				map[sr][sc] += s5;
			else
				sum += s5;

			// a
			sr = nr + dr[dir];
			sc = nc + dc[dir];
			if (rangeCheck(sr, sc))
				map[sr][sc] += a;
			else
				sum += a;

		}

	}

	private static boolean rangeCheck(int sr, int sc) {
		return sr >= 0 && sc >= 0 && sr < N && sc < N;
	}

}

