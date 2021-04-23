package SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G2_17143_낚시왕 {
	static int R, C, M;
	static Shark[][] map;
	static int dr[] = { 0, -1, 1, 0, 0 }; // 북남동서
	static int dc[] = { 0, 0, 0, 1, -1 };
	static ArrayList<Shark> list;
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Shark shark;
		map = new Shark[R + 1][C + 1];
		list = new ArrayList<Shark>();
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			shark = new Shark(r, c, s, d, z);
			list.add(shark);
			map[r][c] = shark; // 상어가 map에 저장
		}

		process();
		System.out.println(sum);
	}

	private static void process() {

		for (int i = 1; i <= C; i++) {
			pick(i);
			move();
			kill();
		}

	}

	private static void kill() {
		// 재배치 및 중첩된 샤크 제거하기
		map = new Shark[R + 1][C + 1];
		int size = list.size();
		for (int i = size - 1; i >= 0; i--) {
			Shark s = list.get(i);
			if (map[s.r][s.c] == null) {
				map[s.r][s.c] = s;
			} else {
				// 기존에 있는 상어보다 사이즈가 크면 기존꺼 제거
				if (s.size > map[s.r][s.c].size) {
					list.remove(map[s.r][s.c]);
					map[s.r][s.c] = s;
				} else { // 내가 작으면 나를 제거
					list.remove(s);
				}
			}
		}

	}

	private static void move() {
		for (Shark shark : list) {
			int nr = shark.r;
			int nc = shark.c;
			int s = shark.speed;
			int d = shark.dir;
			if (d == 1 || d == 2) {
				s = s % ((R - 1) * 2);
				for (int i = 0; i < s; i++) {
					if (nr == 1) {
						d = 2;
					} else if (nr == R) {
						d = 1;
					}
					nr += dr[d];
				}
				shark.r = nr;
				shark.dir = d;
			} else {
				s = s % ((C - 1) * 2);
				for (int i = 0; i < s; i++) {
					if (nc == 1) {
						d = 3;
					} else if (nc == C) {
						d = 4;
					}
					nc += dc[d];
				}
				shark.c = nc;
				shark.dir = d;
			}

		}
	}

	private static void pick(int c) {
		for (int i = 1; i <= R; i++) {
			if (map[i][c] != null) {
				sum += map[i][c].size;
				list.remove(map[i][c]);
				break;
			}
		}

	}

	static class Shark {
		int r, c, speed, dir, size;

		public Shark(int r, int c, int speed, int dir, int size) {
			super();
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

	}

}

