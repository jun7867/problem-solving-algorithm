
package com.Boj.Day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_14888 {
	static int N;
	static int[] A; //숫자 
	static int[] cal; // 연산자 개수
	static LinkedList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N=Integer.parseInt(br.readLine());
		A=new int[N];
		cal = new int[4];
		list = new LinkedList<Integer>();
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<4;i++) {
			cal[i]=Integer.parseInt(st.nextToken());
		};
		dfs(A[0],1);
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	
	}

	private static void dfs(int num,int idx) {
		if (idx==N) {
			list.add(num);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(cal[i]>0) {
				// 연산자 사용했으니 1 감소
				cal[i]--;
				if(i==0)
					dfs(num+A[idx],idx+1);
				else if(i==1)
					dfs(num-A[idx],idx+1);
				else if(i==2)
					dfs(num*A[idx],idx+1);
				else if(i==3)
					dfs(num/A[idx],idx+1);
				// 재귀 종료시 다시 연산자 복구
				cal[i]++;
			}
				
		}
		
	}

}

