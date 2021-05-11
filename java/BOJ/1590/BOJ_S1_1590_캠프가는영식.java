package com.Boj.Day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_S1_1590_캠프가는영식 {
	static int N;
	static long T, min;
	static Set<Long> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		T = Long.parseLong(st.nextToken());
		set = new HashSet<Long>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			long start = Long.parseLong(st.nextToken());
			long time = Long.parseLong(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			for (int j = 0; j < M; j++) {
				set.add(start + time * j);
			}
		}

		min = Integer.MAX_VALUE;
		for (Long num : set) {
			if (num - T >= 0)
				min = Math.min(min, num - T);
		}

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);

	}
}

