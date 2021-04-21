package SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G5_15683_감시 {
	static class Camera {
		int r, c, type;

		public Camera(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[] dr = { -1, 0, 1, 0 }; // 상,좌,하,우
	static int[] dc = { 0, -1, 0, 1 }; // 상,좌,하,우
	static int N, M, answer;
	static int[][] map;

	static ArrayList<Camera> camera = new ArrayList<>();

	private static boolean canMove(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= N || Y >= M || map[X][Y] == 6);
	}

	private static boolean[][] copyVisited(boolean[][] visited) {
		boolean[][] newVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newVisited[i][j] = visited[i][j];
			}
		}
		return newVisited;
	}

	private static void watch(int idx, boolean[][] visited) {
		if (idx == camera.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j])
						continue;
					cnt++;
				}
			}
			answer = answer < cnt ? answer : cnt;
			return;
		}

		Camera cur = camera.get(idx);

		if (cur.type == 1) {
			for (int x = 0; x < 4; x++) {
				boolean[][] newVisited = copyVisited(visited);
				int nx = cur.r;
				int ny = cur.c;
				while (canMove(nx, ny)) {
					newVisited[nx][ny] = true;
					nx += dr[x];  // 0 1 2 3 
					ny += dc[x];
				}
				watch(idx + 1, newVisited);
			}
		} else if (cur.type == 2) {
			for (int x = 0; x < 2; x++) {
				boolean[][] newVisited = copyVisited(visited);
				for (int y = 0; y < 2; y++) {
					int nx = cur.r;
					int ny = cur.c;
					while (canMove(nx, ny)) {
						newVisited[nx][ny] = true;
						nx += dr[x + y * 2]; // 02, 13, 
						ny += dc[x + y * 2];
					}
				}
				watch(idx + 1, newVisited);
			}
		} else if (cur.type == 3) {
			for (int x = 0; x < 4; x++) {
				boolean[][] newVisited = copyVisited(visited);
				for (int y = 0; y < 2; y++) {
					int nx = cur.r;
					int ny = cur.c;
					int next = (x + y) % 4;
					while (canMove(nx, ny)) {
						newVisited[nx][ny] = true;
						nx += dr[next]; // 01, 12, 23, 30
						ny += dc[next];
					}
				}
				watch(idx + 1, newVisited);
			}
		} else if (cur.type == 4) {
			for (int x = 0; x < 4; x++) {
				boolean[][] newVisited = copyVisited(visited);
				for (int y = 0; y < 4; y++) {
					if (x == y)
						continue;
					int nx = cur.r;
					int ny = cur.c;
					while (canMove(nx, ny)) {
						newVisited[nx][ny] = true;
						nx += dr[y]; // 123, 023, 013, 012
						ny += dc[y];
					}
				}
				watch(idx + 1, newVisited);
			}
		} else if (cur.type == 5) {
			boolean[][] newVisited = copyVisited(visited);
			for (int x = 0; x < 4; x++) {
				int nx = cur.r;
				int ny = cur.c;

				while (canMove(nx, ny)) {
					newVisited[nx][ny] = true;
					nx += dr[x]; // 0123
					ny += dc[x];
				}
			}
			watch(idx + 1, newVisited);
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		answer = N * M;
		boolean[][] visited = new boolean[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					camera.add(new Camera(i, j, map[i][j]));
				} else if (map[i][j] == 6) {
			 		visited[i][j] = true;
				}
			}
		}

		watch(0, visited);
		System.out.println(answer);
	}

}

