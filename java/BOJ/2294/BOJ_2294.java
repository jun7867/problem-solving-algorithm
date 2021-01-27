package com.Boj.Day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2294 {
	static int n,k;
    static int c[];
    static int dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);
        c = new int[n];
        dp = new int[k+1];
        for(int i=0; i<n; i++) {
            c[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp, 10001);
        dp[0]=0;
        for(int i=0;i<n;i++) {
        	for(int j=c[i];j<=k;j++) {
        		dp[j]=Math.min(dp[j], dp[j-c[i]]+1);
        	}
        }
        
        if(dp[k] ==10001) {
        	System.out.println(-1);
        }else {
        	System.out.println(dp[k]);
        }

	}

}

