package com.ssafy.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중복 순열
public class BOJ_S3_15651 {
	static int N,M;
	static int[] numbers;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		numbers=new int[M];
		permutation(0);
		System.out.println(sb.toString());
	}
	private static void permutation(int idx) {
		if(idx==M) {
			for(int n : numbers)
				sb.append(n+" ");
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			numbers[idx]=i;
			permutation(idx+1);
		}
	}

}

