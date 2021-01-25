package D2;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1288 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N=sc.nextInt();
			int[] used=new int[10];
			int count=1;
			int temp=0;
			while(true) {
				temp=N*count++;
				while(temp>0) {
					if(used[temp%10]==0) {
						used[temp%10]=1;
					}
					temp/=10;
					
				}
				int sum=Arrays.stream(used).sum();
				if(sum==10)
					break;
			}
			System.out.printf("#%d %d\n",tc,N*(count-1));
		}
	}

}

