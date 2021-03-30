package com.Boj.Day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 키 순서를 알려면 자신을 제외한 모든 학생을 다 알아야 한다??

public class BOJ_G4_2458_키순서 {
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				map[i][j] = Integer.MAX_VALUE / 2;
			}
		}

		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
		}

		// 플로이드 출경도
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		

		
		int[] isConnect = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] < Integer.MAX_VALUE/2) {
                	isConnect[i]++;
                	isConnect[j]++;
                }
            }
        }
        
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (isConnect[i] == N - 1) {
                cnt++;
            }
        }
		System.out.println(cnt);
	}

}

