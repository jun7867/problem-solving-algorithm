package com.Boj.Day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_2234_성곽 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int dr[] = { 0, -1, 0, 1 };
	static int dc[] = { -1, 0, 1, 0 };
	static int max = 0, cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int room=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j]) {
					room+=1;
					cnt = 1;
					visit[i][j] = true;
					dfs(i, j);
					max = Math.max(max, cnt);
				}
			}
		}
		System.out.println(room);
		System.out.println(max);
		
		// 벽 하나 제거
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit=new boolean[N][M];
				for (int k = 1; k <=8 ; k*=2) {
					// 벽 
					if((map[i][j] & k) ==k) {
						visit[i][j]=true;
						cnt=1;
						map[i][j]-=k; // 벽제거
						dfs(i,j);
						max = Math.max(max, cnt);
						map[i][j]+=k; // 되돌리기
					}
				}
				
			}
		}
		System.out.println(max);

	}

	private static void dfs(int r, int c) {

		for (int i = 1; i <= 8; i *= 2) {
			if ((map[r][c] & i) != i) {
				int d = i / 2;
				if(d==4) d--;
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visit[nr][nc]) {
					visit[nr][nc] = true;
					cnt++;
					dfs(nr, nc);
				}
			}

		}

	}
}

