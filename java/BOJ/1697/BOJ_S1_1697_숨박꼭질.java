package com.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs 
public class BOJ_S1_1697_숨바꼭질 {
	static int N, K;
	static int[] map = new int[100001];
	static int cnt;
	static boolean[] visit = new boolean[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs(N);

	}

	private static void bfs(int start) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(start, 0));
		cnt = 0;

		while (!q.isEmpty()) {
			Node cur = q.poll();
			if(visit[cur.p]) continue;
			
			visit[cur.p] = true;

			if (cur.p == K) {
				System.out.println(cur.t);
				return;
			}
			if (cur.p - 1 >= 0)
				q.add(new Node(cur.p - 1, cur.t + 1));
			if (cur.p + 1 <= 100000)
				q.add(new Node(cur.p + 1, cur.t + 1));
			if (2 * cur.p <= 100000)
				q.add(new Node(cur.p * 2, cur.t + 1));

		}
	}
}

class Node {
	int p, t;

	public Node(int p, int t) {
		super();
		this.p = p;
		this.t = t;
	}

}
