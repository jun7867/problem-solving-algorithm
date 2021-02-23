package com.Boj.Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위상정렬?
// dfs 시간초과... => + DP??
public class BOJ_G3_1005_ACMCraft {
	static int N,K,W;
	static int[] D;
	static ArrayList<Integer>[] list;
	static int max;
	static int timeSum;
	static int[] DP;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int tc=1;tc<=T;tc++) {
			st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			D=new int[N+1];
			DP=new int[N+1];
			st=new StringTokenizer(br.readLine()," ");
			for(int i=1;i<=N;i++) {
				D[i]=Integer.parseInt(st.nextToken());
			}
			
			list=new ArrayList[N+1];
			int[] targetCount=new int[N+1];
			for(int i=1;i<=N;i++) {
				list[i]=new ArrayList<Integer>();
			}
			for(int i=0;i<K;i++) {
				st=new StringTokenizer(br.readLine()," ");
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				list[a].add(b); // a->b
				targetCount[b]++; // b를 거쳐야 하는 개수
			}
			W=Integer.parseInt(br.readLine());	
			max=0;
			
			
			// 처음으로 시작하는 것들을 q에 넣는다. (이 문제에서는 1) 
			Queue<Integer> q = new LinkedList<Integer>();
			for(int i=1;i<=N;i++) {
				DP[i]=D[i];
				if(targetCount[i]==0) {
					q.add(i);
					
				}
					
			}
			
			while(!q.isEmpty()) {
				int cur=q.poll();
				for(int i=0;i<list[cur].size();i++) {
					// 이전 테크 + 지금 시간 , 지금까지 max 시간 비교해서 max로 update.
					int next=list[cur].get(i);
					DP[next]=Math.max(DP[next],DP[cur]+D[next]);
					targetCount[next]--;
					if(targetCount[next]==0)
						q.add(next);
					
				}		
		
			}
			System.out.println(DP[W]);
				
		}
	}

}

