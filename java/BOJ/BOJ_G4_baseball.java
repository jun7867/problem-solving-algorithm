package com.Boj.seoul8.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 순열 + 시물레이션
public class BOJ_G4_17281_baseball {
	static int N;
	static int max = 0;
	static int[][] player;
	static boolean[] visit = new boolean[10];
	static int[] playOrder = new int[10];

	// 순열로 브루트 포스
	private static void permutation(int idx) {
		if (idx == 10) {
			play();
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (!visit[i]) {
				visit[i] = true;
				playOrder[i] = idx; // 1번을 제외한 수들이 순열로 저장됨
				permutation(idx + 1);
				visit[i] = false;
			}
		}

	}

	private static void play() {
		int curPlay = 1;
		int score = 0;
		for (int i = 1; i <= N; i++) {
			int outCnt = 0;
			int p1 = 0;
			int p2 = 0;
			int p3 = 0;
			while (outCnt < 3) {
				if (curPlay == 10)
					curPlay = 1;
				
				// 현재 이닝에서 타석에 나서는 play
				switch (player[i][playOrder[curPlay]]) {
				case 0:
					outCnt++;
					break;
				case 1:
					// 3루에 있는 사람이 있다면 +1점
					score += p3;
					p3 = p2;
					p2 = p1;
					p1 = 1;
					break;

				case 2:
					score += p3 + p2;
					p3 = p1;
					p2 = 1;
					p1 = 0;
					break;

				case 3:
					score += p3 + p2 + p1;
					p3 = 1;
					p2 = 0;
					p1 = 0;
					break;
				case 4:
					score += p3 + p2 + p1 + 1;
					p1 = 0;
					p2 = 0;
					p3 = 0;
					break;
				}
				curPlay++;
			}
		}
		max = max < score ? score : max;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		player=new int[N+1][10];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 9; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1번 4번 타자로 고정
		visit[4] = true;
		playOrder[4] = 1;

		// 1번은 이미 정해졌으니 2번부터 순열 돌리기
		permutation(2);
		System.out.println(max);
	}

}

