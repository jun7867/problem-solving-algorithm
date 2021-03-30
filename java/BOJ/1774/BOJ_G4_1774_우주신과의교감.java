ipackage com.Boj.Day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_1774_우주신과의교감 {
	static class Edge implements Comparable<Edge> {
		int from, to;
		double distance;

		public Edge(int from, int to, double distance) {
			super();
			this.from = from;
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.distance, o.distance);
		}
	}

	static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	} // 대표자 찾기

	static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	static int N, M;
	static int parents[];
	static int[][] god;
	static Edge[] edgeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		god = new int[N+1][2];
		edgeList = new Edge[N * (N - 1) / 2];
		int a, b;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			god[i][0] = a;
			god[i][1] = b;
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				edgeList[cnt++] = new Edge(i, j, dist(i, j));
			}
		}
		Arrays.sort(edgeList);
		parents = new int[N+1];
		make();
		double sum=0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		for (Edge edge: edgeList) {
			if(union(edge.from,edge.to)) {
				sum+=edge.distance;
			}
		}
		
		System.out.printf("%.2f",sum);
		
		
		
		
	}

	private static double dist(int i, int j) {
		double d = (double) (Math.pow(god[i][0] - god[j][0], 2) + Math.pow(god[i][1] - god[j][1], 2));
		d = Math.sqrt(d);
		return d;
	}

}
`
