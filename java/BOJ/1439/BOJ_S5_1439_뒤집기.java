package com.Boj.Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S5_1439_뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int cnt=0;
		char curS=s.charAt(0);
		char check=s.charAt(0);
		for(int i=1;i<s.length();i++) {
			if(curS !=s.charAt(i) && check !=s.charAt(i)) {
				cnt++;
			}
			curS=s.charAt(i);
		}
		System.out.println(cnt);

	}

}

