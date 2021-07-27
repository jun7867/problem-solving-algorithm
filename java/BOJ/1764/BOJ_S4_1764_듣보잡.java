package com.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BOJ_S4_1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");

		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		ArrayList<String> arr = new ArrayList<String>();

		for (int i = 0; i < N; i++) {
			hash.put(br.readLine(), 1);
		}

		for (int i = 0; i < M; i++) {
			String person = br.readLine();

			if (hash.containsKey(person)) {
				arr.add(person);
			}
		}

		Collections.sort(arr);
		System.out.println(arr.size());
		for (String a : arr) {
			System.out.println(a);
		}

	}

}

