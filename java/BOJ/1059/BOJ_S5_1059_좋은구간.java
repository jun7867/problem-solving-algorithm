package com.Boj.Day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_S5_1059_좋은구간 {
	static int L,n;
	static int[] numbers,Nlist;
	static int sum=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Nlist = new int[L+1];
		Nlist[0]=0;
		for(int i=1;i<L+1;i++)
			Nlist[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(Nlist);
		n=Integer.parseInt(br.readLine());

		int left=0;
		int right=0;
		for(int x : Nlist) {
			if(x==n) {
				System.out.println(0);
				return;
			}
			
			if (n > x)
				left=x+1;
			else {
				right=x-1;
				break;
			}
		}
		sum+=(right-left) + (right-n)*(n-left);
		System.out.println(sum);
	}
}

