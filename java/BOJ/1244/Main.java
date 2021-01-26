import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] state;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		state=new int[N];
		for(int i=0;i<N;i++) {
			state[i]=sc.nextInt();
		}
		int studentNum=sc.nextInt();
		for(int i=0;i<studentNum;i++) {
			int gender=sc.nextInt();
			int index=sc.nextInt();
			
			if(gender==1) {
				for(int j=index-1;j<N;j+=index) {
					Change(j);
				}
			} else {
				int c=0;
				while(true) {
					if(c==0)
						Change(index-1);
					c++;
					if(index-c-1<0 || index+c-1 >= N) {
						break;
					}
					if(state[index-1-c] != state[index-1+c]) {
						break;
					} else {
						Change(index-1-c);
						Change(index-1+c);
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			if(i!=0 && i%20==0) {
				System.out.println("");
			} 
			System.out.print(state[i]+" ");
			
		}

	}
	public static void Change(int idx) {
		if(state[idx]==1)
			state[idx]=0;
		else
			state[idx]=1;
	}

}

