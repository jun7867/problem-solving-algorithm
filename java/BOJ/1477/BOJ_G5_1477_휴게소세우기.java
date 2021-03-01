package com.Boj.Day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//이분 탐색 (Parametric search) 
public class BOJ_G5_1477_휴게소세우기 {
	static int N, M, L;
	static int[] rest;
	static int left, right;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		rest = new int[N + 2];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			rest[i] = Integer.parseInt(st.nextToken());
		}
		// 도로의 시작 , 끝도 휴게소로 넣어줘야 한다.
		rest[0] = 0;
		rest[N + 1] = L;
		Arrays.sort(rest);

		binarySearch();
		System.out.println(left);
	}

	// 0 82 201 411 555 622 755 800
	// 휴게소 m개를 추가로 지었을 때, 각 휴게소 사이의 거리의 최대값이 d 이하가 되게 만들 수 있는가? => T / F
	// M개를 설치했을 때 각 휴게소끼리의 거리의 최대값을 mid라고 하자. 조건을 충족하는 최적의 mid를 찾아가는 방식이다.
	// 만약 400일때 조건을 충족한다면 0~399는 볼필요도 없다. 401부터 최대값을 찾아나간다.
	private static void binarySearch() {
		left = 0;
		right = L;

		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;

			for (int i = 1; i < N + 2; i++)
				// 휴게소 사이 거리가 mid라고 했을때, 현재 세워진 휴게소 사이에 새로 끼워 넣을 수 있는 휴게소 수.
				sum += (rest[i] - rest[i - 1] - 1) / mid;
			
//			System.out.println("mid: "+mid+" sum: "+sum+", L: "+left+" right: "+right);
			// 현재 mid의 거리 차이가 가능하다면 => 더 최대값을 찾기 위해 더 넓은 범위 탐색. 
			if (sum > M)
				left = mid + 1;

			// 더 적게 세워야 하면 간격을 줄인다.
			else
				right = mid - 1;

		}

	}

}

