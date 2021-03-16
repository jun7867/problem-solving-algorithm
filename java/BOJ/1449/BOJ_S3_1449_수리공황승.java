package com.Boj.Day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_1449_수리공황승 {
	static int N,L;
	static int[] position;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		position=new int[N];
		for(int i=0;i<N;i++) {
			position[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(position);
		
		int cnt=1;
		int start=position[0];
		for(int i=1;i<N;i++) {
			if(position[i] <=start+L-1) {
				continue;
			} else {
				cnt++;
				start=position[i];
			}
		}
		System.out.println(cnt);
	}

}

