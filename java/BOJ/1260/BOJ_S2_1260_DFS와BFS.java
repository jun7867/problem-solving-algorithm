package com.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_1260_DFS와BFS {
	
	static class Node implements Comparable<Node>{
		int v;

		public Node(int v) {
			super();
			this.v = v;
		}

		@Override
		public int compareTo(Node o) {
			return this.v-o.v;
		}
		
	}
	
	static int N,M,V;
	static int from,to;
	static LinkedList<Node>[] adjList;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		V=Integer.parseInt(st.nextToken());
		
		adjList=new LinkedList[N+1];
		
		for(int i=0;i<N+1;i++)
			adjList[i]=new LinkedList<Node>();
		
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine()," ");
			from=Integer.parseInt(st.nextToken());
			to=Integer.parseInt(st.nextToken());
			adjList[from].add(new Node(to));
			adjList[to].add(new Node(from));
		}
		for(int i=0;i<N;i++)
			Collections.sort(adjList[i]);
		
		visit=new boolean[N+1];
		dfs(V);
		System.out.println();
		
		visit=new boolean[N+1];
		bfs(V);
		
	}
	
	private static void bfs(int cur) {
		Queue<Integer> q = new LinkedList<Integer>();
		visit[cur]=true;
		
		q.add(cur);
		
		while(!q.isEmpty()) {
			cur=q.poll();
			System.out.print(cur+" ");
			
			for(Node tmp: adjList[cur]) {
				if(!visit[tmp.v]) {
					q.add(tmp.v);
					visit[tmp.v]=true;
				}
			}
			
		}
		
	}

	private static void dfs(int cur) {
		
		visit[cur]=true;
		System.out.print(cur+" ");
		for(Node tmp: adjList[cur]) {
			if(!visit[tmp.v])
				dfs(tmp.v);
		}
		
	}

}

