package com.Boj.Day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 플루이드
public class BOJ_S1_1058_친구 {
	static int N, result = 0;
	static int[][] friend;

	private static void countFriend() {
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {

				// 나는 제외!
				if (i == j)
					continue;

				// 한 다리 건너서 아는 친구 + 서로 친구
				else if (friend[i][j] <= 2)
					sum++;
			}
			result = Math.max(result, sum);
		}

	}

	private static void floyd() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j || j == k || i == k)
						continue;
					else if (friend[i][j] > friend[i][k] + friend[k][j])
						friend[i][j] = friend[i][k] + friend[k][j];
				}
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		friend = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= N; j++) {
				char ch = s.charAt(j - 1);

				if (ch == 'Y')
					friend[i][j] = 1;
				else
					friend[i][j] = 10000000;
			}
		}

		floyd();
		countFriend();

		System.out.println(result);

	}

}

