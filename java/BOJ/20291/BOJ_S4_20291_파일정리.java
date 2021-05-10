package com.Boj.seoul8.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Map;
import java.util.TreeMap;

public class BOJ_S4_20291_파일정리 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Map<String, Integer> map=new TreeMap<>();
		
		for (int i = 0; i < N; i++) {
			String[] str= br.readLine().split("\\.");
			if(!map.containsKey(str[1]))
				map.put(str[1], 1);
			else
				map.put(str[1],map.get(str[1])+1);
		}
		
		for (String s : map.keySet()) {
			System.out.println(s+" "+map.get(s));
		}

	}

}

