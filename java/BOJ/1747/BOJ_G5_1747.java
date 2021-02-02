package com.Boj.Day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_G5_1747 {
	// N이 1000000일뿐 그거까지가 범위를 한계를 두면 안된다... 문제를 잘읽자..
	static int M=10000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		//1. 에라토스테네스의체 소수 => 2. 팰린드롬 찾기?
		boolean[] prime=new boolean[M+1];
		Arrays.fill(prime, true);
		prime[0]=false;
		prime[1]=false;
		ArrayList<Integer> list= new ArrayList<Integer>(); 
		for(int i=2;i<M+1;i++) {
			if(prime[i]) {
				if(i>=N) {
					list.add(i);
				}
			}
			for(int j=i;j<M+1;j+=i) {
				prime[j]=false;
			}
		}
		// list에는 소수들이 저장.
		loop:
		for(Integer p : list) {
			String str=String.valueOf(p);
			//짝수 
			if(str.length()%2==0) {
				for(int i=0;i<str.length()/2;i++) {
					if(str.charAt(i)!=str.charAt(str.length()-i-1)) {
						continue loop;
					}
				}
				System.out.println(p);
				break;
			}else { // 홀
				for(int i=0;i<str.length()/2;i++) {
					if(str.charAt(i)!=str.charAt(str.length()-i-1)) {
						continue loop;
					}
				}
				System.out.println(p);
				break;
			}
		}
		

	}

}

