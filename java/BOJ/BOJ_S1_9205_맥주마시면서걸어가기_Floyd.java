package com.ssafy.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_9205_맥주마시면서걸어가기_Floyd {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int N, x, y;
	static Point[] store;
	static boolean[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			store = new Point[N + 2];
			st = new StringTokenizer(br.readLine(), " ");
			store[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				store[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine(), " ");
			store[N + 1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			map = new boolean[N + 2][N + 2];

			// 직접 연결들이 1000 이하인지 확인
			connect();
			// floyd로 연결 가능한지 확인
			floyd();

			print();

		}
	}

	private static void print() {
		if (map[0][N + 1])
			System.out.println("happy");
		else
			System.out.println("sad");

	}

	private static void floyd() {
		for (int k = 0; k < N + 2; k++) {
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					if (!map[i][j]) {
						if (map[i][k] && map[k][j]) {
							map[i][j] = true;
						}
					}
				}
			}
		}

	}

	private static void connect() {
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				if (i == j)
					continue;
				if (dist(store[i], store[j])) {
					map[i][j] = true;
				}
			}
		}
	}

	// 거리가 1000 이하여야 연결 가능
	private static boolean dist(Point p1, Point p2) {
		int dist = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);

		if (dist <= 1000)
			return true;
		return false;
	}
}

