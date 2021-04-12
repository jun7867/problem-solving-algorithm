package SWTEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// 다익스트라
public class SWEA_SWTEST_보급로 {
	static int N;
	static int[][] map;
	static int[][] distance;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			distance = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}

			sb.append("#" + tc + " " + dijkstra() + "\n");
		}
		System.out.println(sb.toString());
	}

	private static int dijkstra() {
		distance[0][0] = map[0][0];

		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.add(new Point(0, 0, map[0][0]));

		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (distance[nr][nc] > distance[cur.r][cur.c] + map[nr][nc]) {
						distance[nr][nc] = distance[cur.r][cur.c] + map[nr][nc];
						pq.add(new Point(nr, nc, distance[nr][nc]));
					}
				}
			}
		}

		return distance[N - 1][N - 1];
	}

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
			return this.w - o.w;
		}

	}
}

