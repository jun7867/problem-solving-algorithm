package com.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_G4_15961_회전초밥 {
	static int N, d, k, c;
	static int max = 0;
	static int[] sushi;
	static int[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[N];

		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		visit = new int[d + 1]; // 초밥 가지수
		visit[c]++;

		// 연속되는 k수로 처음 K개 초밥 수 구하기
		int kindCnt = 1;
		for (int i = 0; i < k; i++) {
			if (visit[sushi[i]] == 0)
				kindCnt++;
			visit[sushi[i]]++;
		}
		max = kindCnt;

		for (int i = 1; i < N + 1; i++) {
			// 맨앞에 하나 빼기
			visit[sushi[i - 1]] -= 1;

			// 0이면 남아있는 종류가 없으므로 종류를 1개 빼준다.
			if (visit[sushi[i - 1]] == 0)
				kindCnt--;

			// 뒤에꺼 하나 더하기
			visit[sushi[(i + k - 1) % N]] += 1;

			// 새로 추가한 스시가 기존에 없었으면 종류 +1
			if (visit[sushi[(i + k - 1) % N]] == 1)
				kindCnt++;

			max = max < kindCnt ? kindCnt : max;
		}
		System.out.println(max);

	}

}

