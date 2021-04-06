package com.Boj.Day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// dfs + dp
public class BOJ_G2_1103_게임 {
	static int N, M;
	static char[][] map;
	static int[][] dp;
	static int cnt = 0;
	static int max = 0;
	static boolean[][] visit;
	static boolean isInfinite;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void dfs(int r, int c, int cnt) {
		if (cnt > max)
			max = cnt;
		dp[r][c] = cnt;

		for (int i = 0; i < 4; i++) {

			int nr = r + dr[i] * (map[r][c] - '0');
			int nc = c + dc[i] * (map[r][c] - '0');

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 'H') {
				// 무한루프 체크
				if (visit[nr][nc]) {
					isInfinite = true;
					return;
				}
				
				// 가지치기. 방문하려는 곳이 현재 count보다 크면 굳이 방문하지 않는다?? 
				if (dp[nr][nc] > cnt)
					continue;

				visit[nr][nc] = true;
				dfs(nr, nc, cnt + 1);
				visit[nr][nc] = false;

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new char[N][M];
		dp = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}

		isInfinite = false;
		visit[0][0] = true;
		dfs(0, 0, 1);

		if (isInfinite)
			System.out.println(-1);
		else
			System.out.println(max);
	}

}

