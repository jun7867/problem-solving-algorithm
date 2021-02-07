package com.ssafy.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 조합
public class BOJ_S3_15650 {
	static int N,M;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		numbers=new int[M];
		combination(0,1);
		
	}
	private static void combination(int idx, int start) {
		if(idx==M) { // 조합을 다 뽑은 것.
			for(int n : numbers)
				System.out.print(n+" ");
			System.out.println();
			return;
		}
		
		for (int i = start; i <= N; i++) {
			numbers[idx]=i;
			combination(idx+1,i+1);
		}
		
	}


}

