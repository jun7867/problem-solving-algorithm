package a_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_17070_파이프옮기기1 {
	static int N;
	static int[][] map;
	static int[] dr = { 0, 1, 1 }; // 우 우하 하
	static int[] dc = { 1, 1, 0 };
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 1,0);
		System.out.println(cnt);
	}

	private static void dfs(int r, int c, int d) {
		if(r==N-1 && c ==N-1) {
			cnt++;
			return;
		}
		int nr, nc;
		for (int i = 0; i < 3; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			
			if ((i == 0 && d == 2) || (i == 2 && d == 0))
				continue;

			if (nr >= N || nc >= N || map[nr][nc] == 1)
				continue;
			// 대각선
			if (i == 1 && (map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1))
				continue;
			dfs(nr,nc,i);

		}
	}
		
		
	}
// 시간초과 
//	private static void bfs(int r, int c) {
//		Queue<Point> q = new LinkedList<Point>();
//		q.add(new Point(r, c, 0));
//
//		while (!q.isEmpty()) {
//			Point cur = q.poll();
//			if (cur.r == N - 1 && cur.c == N - 1) {
//				cnt++;
//				continue;
//			}
//
//			int nr, nc;
//			for (int i = 0; i < 3; i++) {
//				nr = cur.r + dr[i];
//				nc = cur.c + dc[i];
//				
//				if ((i == 0 && cur.d == 2) || (i == 2 && cur.d == 0))
//					continue;
//
//				if (nr >= N || nc >= N || map[nr][nc] == 1)
//					continue;
//				// 대각선
//				if (i == 1 && (map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1))
//					continue;
//				q.add(new Point(nr, nc, i));
//
//			}
//		}
//
//	}


// d (0 : 가로, 1 :대각선, 2: 세로) 
class Point {
	int r, c, d;

	public Point(int r, int c, int d) {
		super();
		this.r = r;
		this.c = c;
		this.d = d;
	}

}
