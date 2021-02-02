package com.Boj.Day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_S5_1969 {
	static char[] usedAp= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s= br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		String[] Dna=new String[N];
		for(int i=0;i<N;i++) {
			Dna[i]=br.readLine();
		}
		//ATGC
		StringBuilder sb= new StringBuilder("");
		int sum=0;
		for(int i=0;i<M;i++) {
			int alpa[]=new int[26];
			int max=-1;
			int maxIndex=0;
			for(int j=0;j<N;j++) {
				alpa[Dna[j].charAt(i)-'A']++;
			}
			
			for(int k=0;k<26;k++) {
				if(max<alpa[k]) {
					max=alpa[k];
					maxIndex=k;
				}
			}
			sb.append(usedAp[maxIndex]);
			sum+=N-max;
		}
		System.out.println(sb.toString());
		System.out.println(sum);
	}

}

