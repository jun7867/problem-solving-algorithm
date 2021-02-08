package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_5215_남준영 {
	static int[] taste;
	static int[] calorie;
	static int max;
	static boolean[] isSelected;
	static int N,L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			L =Integer.parseInt(st.nextToken());
			taste= new int[N];
			calorie= new int[N];
			isSelected=new boolean[N];
			max=0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				taste[i]=Integer.parseInt(st.nextToken());
				calorie[i]=Integer.parseInt(st.nextToken());
			}
			subset(0);
			System.out.printf("#%d %d\n",tc,max);
		}
		

	}
	private static void subset(int idx) {
		if(idx==N) {
			int sumTaste=0;
			int sumCal=0;
			for(int i=0;i<N;i++) {
				if(isSelected[i]) {
					sumTaste+=taste[i];
					sumCal+=calorie[i];
				}
				if(sumCal>L)
					return;
			}
			max=Math.max(max, sumTaste);
			return;
		}
		
		isSelected[idx]=true;
		subset(idx+1);
		isSelected[idx]=false;
		subset(idx+1);
	
	}

}

