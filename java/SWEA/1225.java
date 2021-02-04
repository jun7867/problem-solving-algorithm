package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=10;
		StringTokenizer st = null;
		for(int tc=1;tc<=T;tc++) {
			Queue<Integer> queue=new LinkedList<Integer>();
			br.readLine();
			st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<8;i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			loop:
			while(true) {
				for(int c=1;c<=5;c++) {
					int temp=queue.poll();
					temp-=c;
					temp=temp <0 ? 0 : temp;
					queue.offer(temp);
					if(temp==0)
						break loop;
				}
			}
			System.out.printf("#%d ",tc);
			for(int i=0;i<8;i++) {
				System.out.print(queue.poll()+" ");
			}
			System.out.println();
		}
	}
}

