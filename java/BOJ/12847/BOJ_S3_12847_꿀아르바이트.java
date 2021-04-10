package com.Boj.seoul8.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_12847_꿀아르바이트 {
	static int N, M;
	static long[] T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = new long[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			T[i] = Integer.parseInt(st.nextToken());
		}

		long sum = 0;

		for (int i = 0; i < M; i++) {
			sum += T[i];
		}

		long max = sum;
		
		for (int i = M; i < N; i++) {
			sum += T[i];
			sum -= T[i - M];
			max = max < sum ? sum : max;
		}

		System.out.println(max);

	}

}

