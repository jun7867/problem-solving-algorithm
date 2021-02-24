package IM_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연속되는 길이를 곱한것을 계속 더하면 전체넓이*2개 + 기역자 1개가 나옴. => 빈부분 :  전체넓이 *3 - 곱해서 더한값 .
// 따라서 기역자는 더한값 - 전체넓이*2
public class BOJ_S5_2477_참외밭 {
	static int K;
	static int d;
	static int area;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K=Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int max=0;
		int sum=0;
		st=new StringTokenizer(br.readLine()," ");
		st.nextToken();
		int first=Integer.parseInt(st.nextToken());
		int pre=first;
		for(int i=1;i<6;i++) {
			st=new StringTokenizer(br.readLine()," ");
			st.nextToken();
			d=Integer.parseInt(st.nextToken());
			
			max=Math.max(d*pre, max);
			sum+=d*pre;
			pre=d;
		}
		max=Math.max(first*pre, max);
		sum+=first*pre;
		area=sum-(max*2);
		System.out.println(area*K);

	}

}

