package com.ssafy.twoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_15565_귀여운라이언_twoPoint {

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

		int R = 0, LionCnt = 0, min = N + 1;

		for (int L = 0; L < N; L++) {
			while(R < N && LionCnt < K) {
				if(arr[R]==1)
					LionCnt++;
				R++;
			}
			if(LionCnt == K) {
				min=Math.min(min, R-L);
			}
			// L옮기기 전에 제거해주기
			if(arr[L] == 1) {
				LionCnt--;
			}
		}
		if(min == N+1)
			System.out.println(-1);
		else
			System.out.println(min);
		
	}

}

