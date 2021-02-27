package com.Boj.seoul8.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간합 
public class BOJ_S3_11659_구간합4 {
	static int N,M;
	static int i,j;
	static int[] A,accum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		A=new int[N+1];
		accum=new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1;i<=N;i++)
			A[i]=Integer.parseInt(st.nextToken());
		
		int sum=0;
		for(int i=1;i<=N;i++) {
			sum+=A[i];
			accum[i]=sum;
		}
		
		for(int k=0;k<M;k++) {
			st = new StringTokenizer(br.readLine(), " ");
			i=Integer.parseInt(st.nextToken());
			j=Integer.parseInt(st.nextToken());
			int value=accumulate(i,j);
			System.out.println(value);
		}
			
	}
	private static int accumulate(int i,int j) {
		return accum[j]-accum[i-1];
	}

}

