package com.Boj.Day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_2512_예산 {
	static int N, M, max;
	static long sum;
	static int left, right;
	static int[] numbers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		left = 0;
		right=0;
		numbers = new int[N];
		sum=0;
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			right=Math.max(numbers[i], right);
			sum+=numbers[i];
		}
		M = Integer.parseInt(br.readLine());
		
	
		int mid = 0;
		max = 0;
		if(sum > M) {
			while (left <= right) {
				mid = (left + right) / 2;
				sum = 0;

				sum = checkMid(mid);

//				System.out.println(sum+" "+mid+" "+left+" "+right);
				if (sum <= M) {
					max = mid;
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			System.out.println(max);
		}else {
			System.out.println(right);
		}
		

	}

	private static long checkMid(int mid) {
		for (int n : numbers) {
			int min = Math.min(n, mid);
			sum += min;
		}
		return sum;
	}

}

