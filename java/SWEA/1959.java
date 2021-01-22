
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			int[] A=new int[N];
			int[] B = new int[M];
			int diff= Math.abs(N-M);
			int max=0;
			for(int i=0;i<N;i++) {
				A[i]=sc.nextInt();
			}
			for(int i=0;i<M;i++) {
				B[i]=sc.nextInt();
			}

			if(N==M){
				for(int i=0;i<N;i++) {
					max+=A[i]*B[i];
				}
			} else {
				for(int i=0;i<diff+1;i++) { // 0, 1
					int temp=0;
					if(N<M) {
						for(int j=0;j<N;j++) { // 0 , 1 , 2
							temp+=A[j]*B[j+i];
						}
					} else {
						for(int j=0;j<M;j++) {
							temp+=A[j+i]*B[j];
						}
					}
					if(max < temp)
						max=temp;
				}
			}
			
			System.out.printf("#%d %d\n",tc,max);
		}
	}
}
