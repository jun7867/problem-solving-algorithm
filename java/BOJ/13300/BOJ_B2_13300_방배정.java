package IM_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B2_13300_방배정 {
	static int N,K,S,Y;
	static int[][] student=new int[2][7]; // 0~1 , 1~6 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			S=Integer.parseInt(st.nextToken());
			Y=Integer.parseInt(st.nextToken());
			student[S][Y]++;
		}
		
		int cnt=0;
		for(int i=0;i<2;i++) {
			for(int j=1;j<=6;j++) {
				cnt+=student[i][j] % K ==0 ? student[i][j]/K : (student[i][j]/K) + 1;
			}
		}
		System.out.println(cnt);
		
	}

}

