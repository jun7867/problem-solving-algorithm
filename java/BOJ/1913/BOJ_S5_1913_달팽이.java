package com.Boj.Day19;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_S5_1913_달팽이 {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder("");
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] map = new int[N][N];

		int mid = N / 2;

		int time = 0;
		int nr = mid;
		int nc = mid;
		int corner = 0, cnt = 0, size = 1;
		map[mid][mid] = 1;
		int dir = 0;
		while (time++ != N * N) {
			cnt++;
			nr += dr[dir];
			nc += dc[dir];

			if (nr < 0)
				break;

			if (cnt == size) {
				corner++;
				dir = (dir + 1) % 4;
				cnt = 0;
			}

			if (corner == 2) {
				corner = 0;
				size++;
			}
			map[nr][nc] = time + 1;
		}
		int tr = 0, tc = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == K) {
					tr = i + 1;
					tc = j + 1;
				}
				sb.append(map[i][j]+" ");
			}
			if(i!=N-1)
				sb.append("\n");
		}
		System.out.println(sb.toString());
		System.out.println(tr + " " + tc);
	}

}

