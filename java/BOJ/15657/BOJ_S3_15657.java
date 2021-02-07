package com.ssafy.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 중복조합.
public class BOJ_S3_15657 {
	static int N,M;
	static int[] numbers;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine()," ");
		numbers=new int[N];
		result=new int[M];
		for(int i=0;i<N;i++)
			numbers[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(numbers);
		combination(0,0);
		
	}
	private static void combination(int idx, int start) {
		if(idx==M) { // 조합을 다 뽑은 것.
			for(int r : result) {
				System.out.print(numbers[r] +" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < N; i++) {
			result[idx]=i;
			combination(idx+1,i);
		}
		
	}

}

