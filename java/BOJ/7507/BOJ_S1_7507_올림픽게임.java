package com.Boj.seoul8.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_S1_7507_올림픽게임 {
	static class Game implements Comparable<Game> {
		int s, e;

		public Game(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Game o) {
			int diff = this.e - o.e;
			if (diff == 0)
				diff = this.s - o.s;
			return diff;
		}

	}

	static int T;
	static int N, d, s, e, cnt;
	static PriorityQueue<Game> games;
	static StringBuilder sb = new StringBuilder();;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			games = new PriorityQueue<Game>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				d = Integer.parseInt(st.nextToken());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				games.add(new Game(s + 2400 * (d - 1), e + 2400 * (d - 1)));

			}
			sol();
			sb.append("Scenario #" + tc + ":" + "\n");
			sb.append(cnt + "\n\n");
		}
		System.out.println(sb.toString());
	}

	private static void sol() {
		cnt = 1;
		Game prev = games.poll();
		Game cur;
		for (int i = 1; i < N; i++) {
			cur = games.poll();
			if (prev.e <= cur.s) {
				cnt++;
				prev = cur;
			}
		}
	}
}

