package com.ssafy.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	static int N;
	static int[] R, G, B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = new int[N + 1];
		G = new int[N + 1];
		B = new int[N + 1];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			R[i] = Integer.parseInt(st.nextToken());
			G[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());

		}

		int[][] dp = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			// 빨
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + R[i];
			// 초
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + G[i];
			// 파
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + B[i];
		}
		
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min=Math.min(min,dp[N][i]);
		}
		System.out.println(min);
	}

}

