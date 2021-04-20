package SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_15685_드래곤커브 {
	static int N;
	static int[][] map;
	static int[] dr = { 0, -1, 0, 1 }; // 우 상 좌 히
	static int[] dc = { 1, 0, -1, 0 };
	static ArrayList<Integer> directions;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[101][101];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			directions = new ArrayList<Integer>();

			getDirection(d, g); // 그리는 순서 list에 저장
			paint(r, c);
		}
		
		System.out.println(count());

	}

	private static int count() {
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void paint(int r, int c) {
		map[r][c] = 1;

		for (Integer dir : directions) {
			r += dr[dir];
			c += dc[dir];

			map[r][c] = 1;
		}

	}

	private static void getDirection(int d, int g) {
		directions.add(d);

		// g세대번 반복
		while (g-- > 0) {
			// 마지막 방향부터 90도씩 꺽이면서 반복됨.
			for (int i = directions.size() - 1; i >= 0; i--) {
				int dir = (directions.get(i) + 1) % 4;
				directions.add(dir);
			}
		}
	}

}

