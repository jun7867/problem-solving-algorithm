package com.Boj.seoul8.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_5567 {
	static int N, M;
	static int[][] map;
	static boolean[] visit;
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		StringTokenizer st;

		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}

		sol(0, 1);
		System.out.println(cnt);
	}

	private static void sol(int idx, int start) {
		for (int i = 2; i <= N; i++) {
			if (map[1][i] == 1) {
				// 친구 체크
				if (!visit[i]) {
					visit[i] = true;
					cnt++;
				}
				
				// 친구의 친구 체크
				for (int j = 2; j <= N; j++) {
					if(!visit[j] && map[i][j]==1) {
						visit[j]=true;
						cnt++;
					}
				}
			}
		}
	}
}

