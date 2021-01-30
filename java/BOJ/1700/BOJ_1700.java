package com.Boj.Day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1700 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] item = new int[K];
		int[] used = new int[K + 1];
		int[] put = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			item[i] = Integer.parseInt(st.nextToken());
			used[item[i]] += 1;
		}

		int count = 0;
		int firstput = 0;
		for (int i = 0; i < K; i++) {
			// 지금 쓰는 값들 -1해서 최신화.
			used[item[i]] -= 1;
			boolean isPlugIn = false;
			// 이미 꽂혀있는지 확인.
			for (int s : put) {
				if (s == item[i]) {
					isPlugIn = true;
					break;
				}
			}
			if (isPlugIn)
				continue;

			if (firstput < N) {
				put[firstput] = item[i];
				firstput++;
			} else {
				// 전선에 꼽아져 있는것이랑 같은게 없으면
				if (!isPlugIn) {
					// 뒤에 한번도 안쓰는게 있다면 뽑기!
					for (int j = 0; j < N; j++) {
						if (used[put[j]] <= 0) {
							isPlugIn = true;
							put[j] = item[i];
							count++;
							break;
						}
					}
					if (isPlugIn)
						continue;

					// 꼽혀있는 것 중에서 마지막에 쓰는 전기용품 뽑기!
					int max = 0;
					int maxIndex = 0;
					for (int j = 0; j < N; j++) {
						for (int q = i + 1; q < K; q++) {
							if (put[j] == item[q]) {
								if (q > max) {
									max = q;
									maxIndex = j;
								}

								break;
							}
						}
					}
					put[maxIndex] = item[i];
					count++;
				}
			}

		}
		System.out.println(count);

	}

}

