package com.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_G2_17472_다리만들기2 {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<Edge> edgeList;
	static int[] parents;
	static int cnt;
	static int edgeCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		islandIden();
		cnt = cnt - 100;
		edgeList = new ArrayList<Edge>();

		islandConnect();
		Collections.sort(edgeList);


		parents = new int[cnt + 101];
		make();

		int result = 0;
		int unionCnt=0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				result += edge.weight;
				unionCnt++;
			}
		}
		if (unionCnt != cnt-1)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	private static void islandConnect() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					connect(i, j, map[i][j]);
				}

			}
		}

	}

	private static void connect(int r, int c, int from) {
		for (int i = 0; i < 4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
				int len = 1;
				while (true) {
					nr += dr[i];
					nc += dc[i];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
						if (map[nr][nc] == 0) {
							len++;
						} else if (map[nr][nc] != 0) {
							if (len >= 2)
								edgeList.add(new Edge(from, map[nr][nc], len));
							break;
						}

					} else {
						break;
					}
				}
			}
		}
	}

	private static void islandIden() {
		cnt = 100;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					dfs(i, j, cnt++);
				}

			}
		}

	}

	private static void dfs(int r, int c, int key) {
		visit[r][c] = true;
		map[r][c] = key;
		for (int i = 0; i < 4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visit[nr][nc] && map[nr][nc] == 1) {
				dfs(nr, nc, key);
			}
		}
	}

	private static void make() {
		for (int i = 0; i <= 100 + cnt; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) {
			parents[aRoot] = b;
			return true;
		}
		return false;
	}
}

