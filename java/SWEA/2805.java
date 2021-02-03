package D3;

import java.util.Scanner;

public class Solution_D3_2805_남준영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N=sc.nextInt();
			int sum=0;
			for(int i=0;i<N;i++) {
				String s=sc.next();
				for(int j=0;j<N;j++) {
					int value=s.charAt(j)-'0';
					if(i<N/2+1) {
						if(j>=N/2-i && j<=N/2+i)
							sum+=value;
					} else { // 절반을 지나고!
						int k=N-i-1;
						if(j>=N/2 -k && j<=N/2 +k) {
							sum+=value;
						}
					}
				}
			}
			System.out.printf("#%d %d\n",tc,sum);	
		}
	}

}

