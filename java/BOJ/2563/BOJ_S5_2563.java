package com.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//0209 Homework
public class BOJ_S5_2563_남준영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[][] map=new int[101][101];
		int x,y;
		int count=0;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			for(int j=100-y-10;j<100-y;j++) {
				for(int k=x;k<x+10;k++) {
					if(j>100 || k >100) continue;
					
					if(map[j][k]==1)
						continue;
					map[j][k]=1;
					count++;
				}
			}

		}
		System.out.println(count);

	}

}

