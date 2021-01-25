package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1285 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int T2=Integer.parseInt(br.readLine());
			int[] count=new int[101];
			int score=0;
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<1000;i++) {
				score=Integer.parseInt(st.nextToken());
				count[score]+=1;
			}
			int max=0;
			int ans=0;
			for(int i=0;i<101;i++) {
				if(max<=count[i]) {
					max=count[i];
					ans=i;
				}
			}
			System.out.printf("#%d %d\n",tc,ans);
			

		}
	}

}

