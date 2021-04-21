package SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G1_1194_달이차오른다가자 {
	static class Point {
		int r, c, cnt, key;

		public Point(int r, int c, int cnt, int key) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.key = key;
		}
	}

	static int N, M;
	static char[][] map;
	static boolean[][][] visit;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int min = Integer.MAX_VALUE;
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M][256];
		q = new LinkedList<Point>();

		String t;
		for (int i = 0; i < N; i++) {
			t = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = t.charAt(j);
				if (map[i][j] == '0') {
					// r,c, 이동횟수, key
					q.offer(new Point(i, j, 0, 0));
					visit[i][j][0] = true;
					map[i][j] = '.';
				}
			}
		}

		bfs();
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	private static void bfs() {

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (canMove(nr, nc) && !visit[nr][nc][cur.key] && map[nr][nc] != '#') {
					// 탈출
					if (map[nr][nc] == '1') {
						min = Math.min(min, cur.cnt + 1);
					} else if (map[nr][nc] == '.') { // 이동
						visit[nr][nc][cur.key] = true;
						q.add(new Point(nr, nc, cur.cnt + 1, cur.key));
					} else {
						// 존재하는 키 (a~f)
						if (isKey(nr, nc)) {
							// 비트마스크 => 키가 체크 안되어있으면
							int bit = (1 << map[nr][nc] - 'a');
							if ((cur.key & bit) == 0) {
								visit[nr][nc][cur.key + bit] = true;
								q.add(new Point(nr, nc, cur.cnt + 1, cur.key + bit));
							} else { // 가지고 있는 키면
								visit[nr][nc][cur.key] = true;
								q.add(new Point(nr, nc, cur.cnt + 1, cur.key));
							}
						}
						// A~F 문
						else {
							int bit = (1 << map[nr][nc] - 'A');
							// A~F문에 맞는 key가 있으면
							if ((cur.key & bit) >= 1) {
								visit[nr][nc][cur.key] = true;
								q.add(new Point(nr, nc, cur.cnt + 1, cur.key));
							}
						}
					}
				}
			}

		}
	}

	// 존재하는 열쇠인지 확인 a~f 사이만 가능
	private static boolean isKey(int r, int c) {
		int key = map[r][c] - 'a';
		if (0 <= key && key <= 'f' - 'a')
			return true;
		return false;
	}

	private static boolean canMove(int r, int c) {
		return (r >= 0 && r < N && c >= 0 && c < M);
	}

}

