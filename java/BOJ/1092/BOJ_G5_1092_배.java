package com.Boj.Day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_G5_1092_배 {
	static int N, M;
	static ArrayList<Integer> krain;
	static ArrayList<Integer> box;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		krain = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			krain.add(Integer.parseInt(st.nextToken()));
		}

		M = Integer.parseInt(br.readLine());
		box = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(krain, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		int time = 0;
		if (box.get(0) > krain.get(0))
			System.out.println(-1);
		else {

			while (!box.isEmpty()) {
				int idx = 0;
				for (int i = 0; i < N;) {
					// 다옮긴 경우
					if (idx == box.size())
						break;
					else if (krain.get(i) >= box.get(idx)) {
						box.remove(idx);
						i++;
					} else
						idx++;
				}
				time++;
			}
			System.out.println(time);
		}
		
	}

}

