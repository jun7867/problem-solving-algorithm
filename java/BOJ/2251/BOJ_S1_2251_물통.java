package com.Boj.seoul8.week11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_S1_2251_물통 {
	static boolean[][] visit;
	static Set<Integer> set;
	static int AF, BF, CF;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		AF = sc.nextInt();
		BF = sc.nextInt();
		CF = sc.nextInt();

		visit = new boolean[201][201];
		set = new HashSet<Integer>();
		dfs(0, 0, CF);
		ArrayList<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        
        for (Integer n : ans) {
			System.out.print(n+" ");
		}
	}

	private static void dfs(int a, int b, int c) {
		if (visit[a][b])
			return;

		if (a == 0)
			set.add(c);

		visit[a][b] = true;

		// c => a 이동 가능?
		if (c + a <= AF)
			dfs(a + c, b, 0);
		else
			dfs(AF, b, a + c - AF);

		// c => b 이동 가능?
		if (c + b <= BF)
			dfs(a, b + c, 0);
		else
			dfs(a, BF, b + c - BF);

		// b => a
		if (b + a <= AF)
			dfs(a + b, 0, c);
		else
			dfs(AF, a + b - AF, c);

		// b => c
		if (b + c <= CF)
			dfs(a, 0, b + c);
		else
			dfs(a, b + c - CF, CF);
		
		// a => b
		if(a+b <=BF)
			dfs(0,a+b,c);
		else
			dfs(a+b-BF,BF,c);
		
		// a=> c
		if(a+c <=CF)
			dfs(0,b,a+c);
		else
			dfs(a+c-CF,b,CF);

	}

}

