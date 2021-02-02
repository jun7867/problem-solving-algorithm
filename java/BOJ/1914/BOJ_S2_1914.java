package com.Boj.Day3;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_S2_1914 {
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		BigInteger count=new BigInteger("1");
		BigInteger sub=new BigInteger("1");
		BigInteger multi=new BigInteger("2");
		if(N==1) System.out.println(1);
		//count따로..? 너무 커서 규칙 => 1 -> 3 -> 7 -> 15 -> 31 => 2^n-1
		else {
			//BigInteger.... ? * / ?
			for(int i=0;i<N;i++) {
				count=count.multiply(multi);
			}
			count=count.subtract(sub);
			System.out.println(count);
		}
		if(N<=20) {
			// from -> to 순서를 보여줌..
			
			hanoi(N,'1','2','3');
		}
		
	}

	private static void hanoi(int num,char from,char temp,char to) {
		if(num==1) {
			System.out.println(from+" "+to);
			return;
		}
		hanoi(num-1,from,to,temp);
		System.out.println(from+" "+to);
		hanoi(num-1,temp,from,to);
		
	}

}

