package jungol;

import java.util.Scanner;

public class Main_1411_두줄로타일깔기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int[] dp = new int[N+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=3;
		
		for(int i=3;i<=N;i++) {
			dp[i]=(dp[i-1]+dp[i-2]*2) % 20100529;
		}
		System.out.println(dp[N]);

	}

}

