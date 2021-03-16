package com.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_1759_암호만들기 {
	static int L,C;
	static char[] word;
	static char[] comWords;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		L=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		word=new char[C];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<C;i++) {
			word[i]=st.nextToken().charAt(0);
		}
		Arrays.sort(word);
		
		comWords=new char[L];
		combination(0,0);
		
	}
	private static void combination(int idx, int start) {
		if(idx==L) {
			int cnt=0;
			int cnt2=0;
			for(char w : comWords) {
				if(w =='a' || w =='e' ||w =='o' ||w =='u' ||w =='i')
					cnt++;
				else
					cnt2++;
			}
			if(cnt >=1 && cnt2 >=2)
				System.out.println(comWords);
			return;
		}
		
		for(int i=start;i<C;i++) {
			comWords[idx]=word[i];
			combination(idx+1, i+1);
		}
		
	}

}

