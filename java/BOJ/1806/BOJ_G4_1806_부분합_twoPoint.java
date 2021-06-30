package com.ssafy.twoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_1806_부분합_twoPoint {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int R = 0, sum = 0, ans = N+1;
		
		for (int L = 0; L < N; L++) {
			while (sum < S && R < N) {
				sum += arr[R];
				R++;
			}
			if (sum >= S) {
				ans = Math.min(ans, R - L);
			}
			sum -= arr[L];
		}
		if(ans==N+1)
			System.out.println(0);
		else
			System.out.println(ans);

	}

}

