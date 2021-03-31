package com.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G2_1242_소풍 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		int M = Integer.parseInt(str[2])-1;
		
		// 5 2 3
		int cnt = 1;
		int start=0;
		while (true) {
			int remove=(start+K-1) % N;
			if(remove==M) {
				break;
			} else if(remove < M) {
				M-=1; // 내 앞에가 빠졌으니까 N하고 M 한자리씩 당겨짐
			}
			start=remove;
			N-=1;
			cnt++;
		}
		System.out.println(cnt);
	}

}

