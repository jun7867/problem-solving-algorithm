package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D2_1945 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] div= {2,3,5,7,11};
		int[] divArray=new int[5];
		for (int tc = 1; tc <= T; tc++) {
			int N=Integer.parseInt(br.readLine());
			
			for(int i=0;i<div.length;i++) {
				int count=0;
				while(N%div[i] ==0) {
					N/=div[i];
					count++;
				}
				divArray[i]=count;
			}
			System.out.printf("#%d ",tc);
			for(int i=0;i<5;i++)
				System.out.print(divArray[i]+" ");
			System.out.println("");
		}
	}

}

