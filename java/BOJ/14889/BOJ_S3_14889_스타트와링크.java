package com.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_14889_스타트와링크 {
	static int N;
	static int[][] map;
	static int[] numbers;
	static int[] numB;
	static boolean[] visit;
	static int sum = 0;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		numbers = new int[N / 2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combination(0, 0);
		System.out.println(min);
	}

	private static void combination(int idx, int start) {
		if (idx == N / 2) {
			visit = new boolean[N];
			numB = new int[N / 2];

			for (int i = 0; i < N / 2; i++) {
				visit[numbers[i]] = true;
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (!visit[i])
					numB[cnt++] = i;
			}

			diff();
			return;
		}

		for (int i = start; i < N; i++) {
			numbers[idx] = i;
			combination(idx + 1, i + 1);
		}

	}

	private static void diff() {
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {

				if (visit[i] && visit[j]) {
					sumA += map[i][j];
					sumA += map[j][i];
				} else if (!visit[i] && !visit[j]) {
					sumB += map[i][j];
					sumB += map[j][i];
				}
			}
		}
		// 두 팀의 점수 차이 (절댓값)
		int diff = Math.abs(sumA - sumB);
		min = Math.min(diff, min);

	}

}

