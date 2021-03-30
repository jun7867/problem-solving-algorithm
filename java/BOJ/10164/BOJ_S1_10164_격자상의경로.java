package com.Boj.Day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_10164_격자상의경로 {
	static int N, M, K;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		K = Integer.parseInt(str[2]);
		map = new int[N + 1][M + 1];

		map[0][1]=1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] =map[i-1][j] + map[i][j-1]; 
			}
		}

		// 1,1 -> N,M까지 
		if(K==0) {
			System.out.println(map[N][M]);
		}
		// (1,1 -> k까지) * (K부터 끝까지)
		else {
			int kx=K/M + (K % M ==0 ? 0 : 1); 
			int ky=K - (kx-1)*M;
			
			System.out.println(map[kx][ky] * map[N-kx+1][M-ky+1]);
		}

	}



}

