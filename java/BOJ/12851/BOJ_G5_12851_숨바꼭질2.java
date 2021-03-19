package com.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs 
public class BOJ_G5_12851_숨바꼭질2 {
	static int N, K;
	static int[] map = new int[100001];
	static int cnt;
	static int min=1000001;
	static boolean[] visit = new boolean[100001];
	
	static class Node {
		int p, t;

		public Node(int p, int t) {
			super();
			this.p = p;
			this.t = t;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N > K){
			System.out.println(N-K);
			System.out.println(1);
			return;
		}
		bfs(N);
		System.out.println(min);
		System.out.println(cnt);
	}

	private static void bfs(int start) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(start, 0));
		cnt = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			visit[cur.p]=true;
			if(min < cur.t)
				return;
			
			if (cur.p == K) {
				if(cnt==0) {
					min=cur.t;
				}
				if(min==cur.t) {
					cnt++;
				}	
				
			}
			
			
			if (cur.p - 1 >= 0 && !visit[cur.p-1])
				q.add(new Node(cur.p - 1, cur.t + 1));
			if (cur.p + 1 <= 100000 && !visit[cur.p+1])
				q.add(new Node(cur.p + 1, cur.t + 1));
			if (2 * cur.p <= 100000 && !visit[cur.p*2])
				q.add(new Node(cur.p * 2, cur.t + 1));

		}
	}
}


