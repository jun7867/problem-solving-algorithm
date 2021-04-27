package com.Boj.Day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 카탈란수?
public class BOJ_G5_4811_알약 {
	static int N;
	static long[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int time=0;
		dp=new long[31][31];
		dp[1][0]=1; // WH
		dp[2][0]=2; // WWHH, WHWH
		dp[3][0]=5;
		dp[4][0]=14;
		
		dfs(30,0);
		
		while(time <1000) {
			time++;
			N=Integer.parseInt(br.readLine());
			if(N==0)
				break;
			System.out.println(dp[N][0]);
			
		}
	}
	private static long dfs(int W, int H) {
		if(W==0) return 1;
		if(dp[W][H] !=0)
			return dp[W][H];
		
		long cnt=0;
		
		if(W >0) {
			cnt+=dfs(W-1,H+1);
		}
		if(H >0) {
			cnt+=dfs(W,H-1);
		}
		
		return dp[W][H]=cnt;
		
	}

}

