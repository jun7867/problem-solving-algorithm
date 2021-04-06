package com.Boj.Day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// dfs bfs는 시간초과..
// 다익스트라? 2차원 배열..?
public class BOJ_G4_4485_녹색옷입은애가젤다지 {

	static class Point implements Comparable<Point> {
		int r, c, w;

		public Point(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			int diff = this.w - o.w;
			return diff;
		}

	}

	static int N;
	static int[][] map, distance;
	static int min;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			map = new int[N][N];
			distance = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("Problem " + cnt++ + ": " + dijkstra());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int dijkstra() {
		// 초기값
		distance[0][0]=map[0][0];
		
		PriorityQueue<Point> pq=new PriorityQueue<Point>();
		pq.add(new Point(0, 0, map[0][0]));
		
		while(!pq.isEmpty()) {
			Point cur= pq.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr=cur.r+dr[i];
				int nc=cur.c+dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					// 현재 가중치보다 작다면 최소 비용이니까 update
					if(distance[nr][nc] > distance[cur.r][cur.c] + map[nr][nc]) {
						distance[nr][nc]=distance[cur.r][cur.c] + map[nr][nc];
						pq.add(new Point(nr,nc,distance[nr][nc]));
					}
				}
			}
		}
		return distance[N-1][N-1];
	}
	
}

