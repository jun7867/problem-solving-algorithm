package com.ssafy.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D3_1289 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			String s=br.readLine();
			int len=s.length();
			int[] array=new int[len];
			int[] temp=new int[len];
			
			for (int i = 0; i < len; i++) {
				array[i]=s.charAt(i)-'0';
			}
			int count=0;
			for(int i=0;i<len;i++) {
				if(array[i] !=temp[i]) {
					count++;
					for(int j=i+1;j<len;j++) {
						if(temp[j]==0)
							temp[j]=1;
						else
							temp[j]=0;
					}
				}
			}
			System.out.printf("#%d %d\n",tc,count);
		}
		

	}

}

