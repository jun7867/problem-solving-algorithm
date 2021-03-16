package com.Boj.Day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs
public class BOJ_S2_18352_특정거리의도시찾기 {
	static class Node{
		int v;

		public Node(int v) {
			super();
			this.v = v;
		}
		
	}
	
	static int N,M,K;
	static LinkedList<Node>[] adjList;
	static int[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
		
		adjList=new LinkedList[N+1];
		
		for(int i=0;i<N+1;i++)
			adjList[i]=new LinkedList<Node>();
		
		int A,B;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			A=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			adjList[A].add(new Node(B));
		}
		visit = new int[N+1];
		Arrays.fill(visit, -1);
		bfs(X);
		
		boolean check=false;
		for(int i=1;i<N+1;i++) {
			if(visit[i]==K) {
				System.out.println(i);
				check=true;
			}
		}
		
		if(!check)
			System.out.println(-1);
	}
	
	private static void bfs(int X) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(X);
		visit[X]=0;
		while(!q.isEmpty()) {
			X=q.poll();
			for(Node tmp: adjList[X]) {
				if(visit[tmp.v]==-1) {
					visit[tmp.v]=visit[X]+1;
					q.add(tmp.v);
				}
			}
		}
	}

}

