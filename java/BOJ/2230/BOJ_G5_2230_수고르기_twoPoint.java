package com.ssafy.twoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_2230_수고르기_twoPoint {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(A);

		int R = 0, diff = M, min = Integer.MAX_VALUE;

		for (int L = 0; L < N; L++) {
			while (R < N) {
				diff = A[R] - A[L];
				if (diff >= M) {
					min = Math.min(min, diff);
					break;
				} else {
					R++;
				}
			}
		}
		System.out.println(min);
	}

}

