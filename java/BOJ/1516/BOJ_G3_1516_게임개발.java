package com.Boj.Day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_1516_게임개발 {

	static class Node {
		int v;
		public Node(int v) {
			super();
			this.v = v;
		}

	}

	static int N;
	static LinkedList<Node>[] adjList;
	static int[] indegree;
	static int[] max;
	static int[] time;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		adjList = new LinkedList[N + 1];
		indegree= new int[N+1];
		time=new int[N+1];
		max=new int[N+1];
		for (int i = 0; i < N + 1; i++)
			adjList[i] = new LinkedList<Node>();

		int tmp;
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			time[i]=Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				tmp=Integer.parseInt(st.nextToken());
				if(tmp!=-1) {
					adjList[tmp].add(new Node(i));
					indegree[i]++; // 연결된 수 => 0인거는 처음노드
				}
					
			}
		}
		
		bfs();
		for(int i=1;i<N+1;i++)
			System.out.println(max[i]);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<N+1;i++) {
			if(indegree[i]==0) {
				q.add(i);
				max[i]=time[i];
			}
		}
		
		while(!q.isEmpty()) {
			int cur=q.poll();
			for(Node tmp: adjList[cur]) {
				indegree[tmp.v]--;
				max[tmp.v]=Math.max(max[tmp.v], max[cur]+time[tmp.v]);
				if(indegree[tmp.v]==0)
					q.add(tmp.v);
			}
			
			
		}
	}

}

