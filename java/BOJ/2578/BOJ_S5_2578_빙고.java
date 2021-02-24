package IM_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_2578_빙고 {
	static int[][] map=new int[5][5];
	static int[] order=new int[25];
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0;i<5;i++) {
			st= new StringTokenizer(br.readLine()," ");
			for(int j=0;j<5;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<5;i++) {
			st= new StringTokenizer(br.readLine()," ");
			for(int j=0;j<5;j++) {
				order[i*5+j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=0;i<25;i++) {
			remove(order[i]);
			if(checkV()+checkH()+checkDL()+checkDR() >=3) {
				System.out.println(i+1);
				break;
			}		
		}
	}
	
	// 가로 체크
	private static int checkV() {
		int BingoCnt=0;
		for(int i=0;i<5;i++) {
			int cnt=0;
			for(int j=0;j<5;j++) {
				if(map[i][j]==0)
					cnt++;
				else
					break;
			}
			if(cnt==5)
				BingoCnt++;
		}
		
		return BingoCnt;
	}
	// 세로 체크 
	private static int checkH() {
		int BingoCnt=0;
		for(int i=0;i<5;i++) {
			int cnt=0;
			for(int j=0;j<5;j++) {
				if(map[j][i]==0)
					cnt++;
				else 
					break;
			}
			if(cnt==5)
				BingoCnt++;
		}
		
		return BingoCnt;
	}
	// 대각선 오른쪽 위 체크 
	private static int checkDR() {
		int BingoCnt=0;
		int cnt=0;
		for(int i=0;i<5;i++) {
			if(map[i][4-i]==0)
				cnt++;
			else
				break;
		}
		if(cnt==5)
			BingoCnt++;
		return BingoCnt;
	}
	private static int checkDL() {
		int BingoCnt=0;
		int cnt=0;
		for(int i=0;i<5;i++) {
			if(map[i][i]==0)
				cnt++;
			else
				break;
		}
		if(cnt==5)
			BingoCnt++;
		return BingoCnt;
	}

	
	private static void remove(int n) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(map[i][j]==n) {
					map[i][j]=0;
				}
			}
		}
		
	}

}

