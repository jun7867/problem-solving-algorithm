package com.Boj.Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_S3_1269_대칭차집합 {
	static int N,M;
	static int[] A,B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<Integer>();
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++)
			set.add(Integer.parseInt(st.nextToken()));
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<M;i++)
			set.add(Integer.parseInt(st.nextToken()));
		
		int common=N+M-set.size();
		int AB=N-common;
		int BA=M-common;
		System.out.println(AB+BA);
		
	}

}

