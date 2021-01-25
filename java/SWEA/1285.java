package D2;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1285 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N=sc.nextInt();
			int[] distance=new int[N];
			for(int i=0;i<N;i++) {
				distance[i]=Math.abs(sc.nextInt());
			}
			Arrays.sort(distance);
			int count=0;
			int min=distance[0];
			for(int d : distance) {
				if(min==d)
					count++;
			}
			System.out.printf("#%d %d %d\n",tc,min,count);
		}

	}

}

