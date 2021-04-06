package com.Boj.Day12;

import java.util.Scanner;

public class BOJ_S5_1789_수들의합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N=sc.nextLong();
		
		long cnt=0;
		long cur=1;
		
		while(N>0) {
			if(N-cur >= 0) {
				cnt++;
			}
			N-=cur;
			cur++;
		}
		System.out.println(cnt);
	}

}

