package com.Boj.Day12;

import java.util.Scanner;

public class BOJ_S5_1254_팰린드롬만들기 {
	
	private static int sol(String str) {
		int len=str.length();
		
		for (int i = 0; i < len; i++) {
			if(isPalind(str.substring(i))) {
				return len+i;
			}
		}
		return 0;
	}

	private static boolean isPalind(String str) {
		
		int start=0;
		int end=str.length()-1;
		
		while(start<=end) {
			if(str.charAt(start) !=str.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(sol(str));
	}
}

