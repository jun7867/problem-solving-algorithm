package IM_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class BOJ_B2_2605_줄세우기 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		ArrayList<Integer> list = new ArrayList<Integer>();
	
		for(int i=1;i<=N;i++) {
			list.add(Integer.parseInt(st.nextToken()),i);
		}
		Collections.reverse(list);
		for(int n : list) {
			System.out.print(n+" ");
		}
	}

}

