package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1681_해밀턴순환회로 {
	static int N;
	static int map[][];
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;
	static int cost = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		visit = new boolean[N];
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit[0] = true;
		dfs(0, 0, 0);
		System.out.println(min);

	}

	private static void dfs(int idx, int cur, int cost) {
		if (idx == N - 1) {
			if(map[cur][0] !=0) {
				cost += map[cur][0];
				min = Math.min(min, cost);
			}
			
			return;
		}

		if (min < cost) {
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i] && map[cur][i] != 0) {
				visit[i] = true;
				dfs(idx + 1, i, cost + map[cur][i]);
				visit[i] = false;
			}
		}
	}
}

