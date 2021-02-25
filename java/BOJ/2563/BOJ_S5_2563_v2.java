package IM_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_2563_색종이 {
	static int[][] map = new int[100][100];
	static int r,c;
	static int realR,realC;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int cnt=0;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			r=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			realR=100-c-10;
			realC=r;
			
			for(int j=realR;j<realR+10;j++) {
				for(int k=realC;k<realC+10;k++) {
					if(map[j][k]!=1)
						cnt++;
					map[j][k]=1;
				}
			}
		}
		System.out.println(cnt);

	}

}

