package IM_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B1_10163_색종이 {
	static int N;
	static int[][] map=new int[101][101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int x,y,r,c;
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			r=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			
			for(int j=0;j<r;j++) {
				for(int k=0;k<c;k++) {
					if(x+j > 100 || y+k > 100) continue;
					map[x+j][y+k]=i+1;
				}
			}		
		}
		int[] used = new int[N+1];
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				used[map[i][j]]++;
			}
		}
		for(int i=1;i<=N;i++) {
			System.out.println(used[i]);
		}
		

	}

}

