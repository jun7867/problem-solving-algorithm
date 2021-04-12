package com.Boj.seoul8.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_1034_램프 {
	static int N, M, K;
	static int[][] map;
	static int[] zeroCnt;
	static int maxCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][M];
		zeroCnt = new int[N];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j) - '0';
				if (map[i][j] == 0)
					zeroCnt[i] += 1;
			}
		}
		K = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int cnt = 0;

			// K개 보다 많아서 어차피 다 못켜면 pass
			if (zeroCnt[i] > K)
				continue;

			// 둘다 짝이거나 둘다 홀수여야 한다
			if (K % 2 != zeroCnt[i] % 2)
				continue;

			// 같은 패턴을 지니면 +1
			boolean isNotValid;
			for (int k = 0; k < N; k++) {
				isNotValid = false;
				for (int j = 0; j < M; j++) {
					if (map[i][j] != map[k][j]) {
						isNotValid = true;
						break;
					}
				}
				if (!isNotValid)
					cnt++;
			}

			maxCnt = maxCnt < cnt ? cnt : maxCnt;
		}
		System.out.println(maxCnt);
	}
}

