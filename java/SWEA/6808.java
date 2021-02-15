package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_6808_남준영 {
	static int[] numbers;
	static int[] cards,cards2;
	static int win,lose;
	static int sumG,sumI;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int tc=1;tc<=T;tc++) {
			int[] used=new int[19];
			cards = new int[9];
			cards2 = new int[9];
			numbers=new int[9];
			win=0;
			lose=0;
			st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<9;i++) {
				int num=Integer.parseInt(st.nextToken());
				cards[i]=num;
				used[num]=1;
			}
			int c=0;
			for(int i=1;i<=18;i++) {
				if(used[i]==0)
					cards2[c++]=i;
			}
			
			permutation(0,0);
			System.out.printf("#%d %d %d\n",tc,win,lose);
		}
	}

	private static void permutation(int idx,int flag) {
		if(idx==9) {
			sol();
			return;
		}
		for(int i=0;i<9;i++) {
			if((flag & 1 << i) !=0) continue;
			// 인영이의 순열들.
			numbers[idx]=cards2[i];
			permutation(idx+1, (flag | ( 1 << i)));
		}
		
	}

	private static void sol() {
		sumG=0;
		sumI=0;
		
		for(int i=0;i<9;i++) {
			if(cards[i] > numbers[i]) 
				sumG+=cards[i]+numbers[i];
			else
				sumI+=cards[i]+numbers[i];
		}
		
		if(sumG > sumI)
			win++;
		else if(sumG < sumI) {
			lose++;
		}
			
	}

}

