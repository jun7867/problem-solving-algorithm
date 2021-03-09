package com.Boj.Day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 크루스칼 
public class BOJ_G4_1197_최소스패닝트리 {
	static int V,E;
	static int[] parent;
	static int result=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<edge> pq = new PriorityQueue<edge>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		// Unionfind
		parent = new int[V+1];
		
		// 부모 채우기
		for(int i=0;i<V+1;i++)
			parent[i]=i;
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			pq.add(new edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		for(int i=0;i<E;i++) {
			edge curEdge=pq.poll();
		
			int a = find(curEdge.a);
			int b = find(curEdge.b);
			
			// 부모가 같으면 사이클 생기니 pass
			if(a==b) continue;
			union(a,b);
			result +=curEdge.c;
		}
		
		System.out.println(result);
	}
		// 부모 노드 찾기
		public static int find(int x) {
			if (x == parent[x])
				return x;
			else
				return parent[x] = find(parent[x]);
		}

		// 두 부모 합치기
		public static void union(int x, int y) {
			x = find(x);
	        y = find(y);
			if (x < y)
				parent[y] = x;
			else
				parent[x] = y;
		}
}


class edge implements Comparable<edge>{
	int a,b,c;

	public edge(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	// 가중치 내림차순
	@Override
	public int compareTo(edge o) {
		return this.c-o.c;
	}
}
