package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_3499_남준영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<String> leftQ=new LinkedList<String>();
		Queue<String> rightQ = new LinkedList<String>();
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int tc=1;tc<=T;tc++) {
			int N=Integer.parseInt(br.readLine());
			N+=1;
			st =new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N/2;i++) {
				leftQ.offer(st.nextToken());
			}
			for(int i=N/2;i<N-1;i++) {
				rightQ.offer(st.nextToken());
			}
			System.out.printf("#%d ",tc);
			while(!leftQ.isEmpty()) {
				System.out.print(leftQ.poll() +" ");
				if(rightQ.isEmpty())
					break;
				System.out.print(rightQ.poll() +" ");
			}
			System.out.println();
		}
		
	}

}

