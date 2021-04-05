package com.Boj.seoul8.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_2302_극장좌석 {
	static int N, M;
	static long[] dp;
	static long ans = 1;

	private static void init_dp() {
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dp = new long[N + 1];
		init_dp();

		int cur = 1;
		int m = 0;
		for (int i = 0; i < M; i++) {
			m = Integer.parseInt(br.readLine());
			if (m != cur)
				ans *= dp[m - cur];
			cur = m + 1;
		}

		// 끝에서 마지막 vip자석까지 체크
		if (N >= cur) {
			ans *= dp[N + 1 - cur];
		}

		System.out.println(ans);
	}
}

