package com.Boj.Day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 부분집합!
public class BOJ_S1_2961_도영이가만든맛있는음식 {
	static int N;
	static int[] S,B;
	static int min=Integer.MAX_VALUE;
	static boolean[] valid;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st=null;
		S=new int[N];
		B=new int[N];
		valid=new boolean[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			S[i]=Integer.parseInt(st.nextToken());
			B[i]=Integer.parseInt(st.nextToken());
		}
		subset(0);
		System.out.println(min);
	
	}
	private static void subset(int idx) {
		if(idx==N) {
			int sumS=1;
			int sumB=0;
			boolean isUsed=false;
			for(int i=0;i<N;i++) {
				if(valid[i]) {
					sumS*=S[i];
					sumB+=B[i];
					isUsed=true;
				}
			}
			if(isUsed)
				min=Math.min(min, Math.abs(sumS-sumB));
			
			return;
		}
		valid[idx]=true;
		subset(idx+1);
		valid[idx]=false;
		subset(idx+1);
		
	}

}

