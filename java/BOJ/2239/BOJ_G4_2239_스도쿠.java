package com.Boj.Day19;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_G4_2239_스도쿠 {
	static int[][] map;
	static boolean[][] visite;
	static ArrayList<Point> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[9][9];
		visite = new boolean[9][9];

		for (int i = 0; i < 9; i++) {
			String str = sc.next();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j) - '0';
				if (map[i][j] == 0) {
					list.add(new Point(i, j));
				}
			}
		}

		dfs(0);

	}

	private static void dfs(int idx) {
		if (idx >= list.size()) {
			print();
			System.exit(0); // 한번만 출력해주면 됨.
		}

		Point cur = list.get(idx);
		int r = cur.x;
		int c = cur.y;

		for (int v = 1; v <= 9; v++) {
			int tmp = map[r][c];

			// 같은 숫자가 가로 세로 3X3에 없어야함.
			if (!checkR(r, v) || !checkC(c, v) || !checkBox(r, c, v))
				continue;

			map[r][c] = v;
			dfs(idx + 1);
			map[r][c] = tmp;
		}

	}

	private static boolean checkBox(int r, int c, int v) {
		int sr = r / 3 * 3;
		int sc = c / 3 * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[sr + i][sc + j] == v)
					return false;
			}
		}
		return true;
	}

	private static boolean checkC(int c, int v) {
		for (int i = 0; i < 9; i++) {
			if (map[i][c] == v)
				return false;
		}
		return true;
	}

	private static boolean checkR(int r, int v) {
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == v)
				return false;
		}
		return true;
	}

	private static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}

