package com.Boj.seoul8.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_16973_직사각형탈출 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int N, M, H, W;
	static int[][] map;
	static Point S, F;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		S = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		F = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(S);
		visit[S.r][S.c] = true;
		int cnt = -1;
		while (!q.isEmpty()) {

			int size = q.size();
			cnt++;
			for (int c = 0; c < size; c++) {
				Point cur = q.poll();
				if (cur.r == F.r && cur.c == F.c) {
					return cnt;
				}

				for (int i = 0; i < 4; i++) {
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];
					
					if (nr >= 1 && nr + H <= N+1 && nc >= 1 && nc + W <= M+1 && !visit[nr][nc]) {
						if (wallCheck(nr, nc)) {
							visit[nr][nc] = true;
							q.add(new Point(nr, nc));
						}
					}
				}
			}

		}
		return -1;
	}

	private static boolean wallCheck(int nr, int nc) {
		for (int i = nr; i < nr + H; i++) {
			for (int j = nc; j < nc + W; j++) {
				if (map[i][j] == 1)
					return false;
			}
		}
		return true;
	}

}

