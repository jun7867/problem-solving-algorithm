package com.Boj.Day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
public class BOJ_S4_20551_Sort마스터 {
	static int N,M;
	static int[] A,D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		A=new int[N];
		D=new int[M];
		
		for(int i=0;i<N;i++) 
			A[i]=Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++)
			D[i]=Integer.parseInt(br.readLine());
		
		Arrays.sort(A);
		
		for(int i=0;i<N;i++) {
			// 위치 저장.
			if(map.get(A[i]) ==null)
				map.put(A[i], i);
		}
		
		for(int i=0;i<M;i++) {
			if(map.get(D[i])!=null)
				System.out.println(map.get(D[i]));
			else
				System.out.println(-1);
		}
	}

}

