package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라 + PQ 
public class BOJ_G5_1753_최단경로 {
	static class Node{
		int s,e;

		public Node(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}
		
		
	}
	static int V, E;
	static LinkedList<Node>[] adjList;
	static PriorityQueue<Node> pQueue = new PriorityQueue<Node>(new Comparator<Node>() {

		@Override
		public int compare(Node o1, Node o2) {
			return o1.s-o2.s;
		}

	});

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		adjList = new LinkedList[V + 1];
		int[] distance = new int[V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		for (int i = 1; i <= V; i++) {
			adjList[i] = new LinkedList<Node>();
		}

		int u, v, w;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			adjList[u].add(new Node( v, w));
		}

		distance[start] = 0;
		pQueue.offer(new Node (0,start));
		while(!pQueue.isEmpty()) {
			Node cur = pQueue.poll();
			for (Node next : adjList[cur.e]) {
				if(distance[next.s] > cur.s + next.e) {
					distance[next.s] = cur.s + next.e;
					pQueue.offer(new Node (distance[next.s],next.s));
				}
			}
		}
		
		
		for (int i = 1; i <= V; i++) {
			if (distance[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}

	}

}


