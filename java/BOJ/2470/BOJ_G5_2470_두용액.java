package com.Boj.Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 투 포인터?
public class BOJ_G5_2470_두용액 {
	static int N;
	static int [] value;
	static int min=Integer.MAX_VALUE;
	static int resultA,resultB;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		value=new int[N];
		for(int i=0;i<N;i++)
			value[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(value);
		
		isPairSum();
		System.out.println(resultA+" "+resultB);
	}

	private static void isPairSum() {
		int left=0;
		int right = N-1;
		
		while(left < right) {
			int sum=value[left] + value[right];
			int diff = Math.abs(sum);
			if(min > diff) {
				min=diff;
				resultA=value[left];
				resultB=value[right];
			}
			if(sum==0) {
				break;
			}
			else if (sum > 0) {
				right--;
			}
			else {
				left++;
			}
		}
		
	}

}

