package com.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G2_2846_오르막길 {
	static int N;
	static int[] num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int s = 0;
		int max = 0;
		boolean isValid=false;
		for (int i = 1; i < N; i++) {
			if (num[i - 1] >= num[i]) {
				if (i - s >= 2) {
					max = Math.max(max, num[i - 1] - num[s]);
				}
				s = i;
				isValid=true;
			}else {
				isValid=false;
			}
		}
		// 마지막
		if(!isValid) {
			if(N-1-s >=2) {
				max = Math.max(max, num[N-1] - num[s]);
			}
		}
		System.out.println(max);

	}

}

