package com.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_16935 {
	static int N, M, R;
	static int[][] map, temp;
	static int[] oper;

	// 상하 반전.
	private static void oper1() {
		int row = N - 1;
		temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[row][j];
			}
			row--;
		}
		map = temp;
	}

	// 좌우 반전.
	private static void oper2() {
		int col = M - 1;
		temp = new int[N][M];
		// M:6 / 0 <-> 5 1 <->4
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][col--] = map[i][j];
			}
			col=M-1;
		}
		map = temp;
	}

	// 오른쪽 90도 회전.
	private static void oper3() {
		int row = N - 1;
		temp = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[j][row] = map[i][j];
			}
			row--;
		}
		map = temp;
		changeRC();
	}

	// 왼쪽 90도 회전.
	private static void oper4() {
		int row = M - 1;
		int col = 0;
		temp = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[row--][col] = map[i][j];
			}
			col++;
			row = M - 1;
		}
		map = temp;
		changeRC();
	}

	// 시계방향
	private static void oper5() {
		int x = N / 2;
		int y = M / 2;
		temp = new int[N][M];
		// 1 -> 2
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i][j + y] = map[i][j];
			}
		}
		// 2 -> 3
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i+x][j + y] = map[i][j+y];
			}
		}
		// 3 -> 4
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i+x][j] = map[i+x][j+y];
			}
		}
		// 4 -> 1
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i][j] = map[i+x][j];
			}
		}
		map=temp;

	}

	// 반시계 방향
	private static void oper6() {
		int x = N / 2;
		int y = M / 2;
		temp = new int[N][M];
		// 4 -> 3
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i+x][j+y] = map[i+x][j];
			}
		}
		// 3 -> 2
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i][j + y] = map[i+x][j+y];
			}
		}
		// 2 -> 1
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i][j] = map[i][j+y];
			}
		}
		// 1 -> 4
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i+x][j] = map[i][j];
			}
		}
		map=temp;

	}

	private static void changeRC() {
		int t = N;
		N = M;
		M = t;
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		// rotate시 N*M이 M*N으로 바뀌기 때문에 최대로 설정 해줌.
//		int max = Math.max(N, M);
		map = new int[N][M];
		oper = new int[R];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < R; i++)
			oper[i] = Integer.parseInt(st.nextToken());
	}

	static void calculate() {
		for (int i = 0; i < R; i++) {
			int op = oper[i];
			switch (op) {

			case 1:
				oper1();
				break;
			case 2:
				oper2();
				break;
			case 3:
				oper3();
				break;
			case 4:
				oper4();
				break;
			case 5:
				oper5();
				break;
			case 6:
				oper6();
				break;

			}
		}

	}

	public static void main(String[] args) throws IOException {
		init();
		calculate();
		print();
	}

}

