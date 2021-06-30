package com.ssafy.twoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_2559_수열_twoPoint {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int R = 0, sum = 0, max = Integer.MIN_VALUE;

		for (int L = 0; L <= N-K; L++) {
			while (R - L < K && R < N) {
				sum+=arr[R];
				R++;
			}
			max=Math.max(max, sum);
			sum-=arr[L];
		}
		System.out.println(max);

	}

}

