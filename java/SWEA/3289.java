package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3289_서로소집합 {
	static int n,m;
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			parents=new int[n+1];
			StringBuilder sb=new StringBuilder();
			sb.append("#"+tc+" ");
			make();
			for(int i=0;i<m;i++) {
				st=new StringTokenizer(br.readLine()," ");
				int c=Integer.parseInt(st.nextToken());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				
				if(c==0) {
					union(a,b);
				}else {
					if(find(a)==find(b))
						sb.append(1);
					else
						sb.append(0);
				}
			}
			System.out.println(sb.toString());
		}

	}
	private static int find(int a) {
		if(parents[a]==a) return a;
		
		return parents[a] = find(parents[a]);
		
	}
	private static boolean union(int a, int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot]=aRoot;
		return true;
		
	}
	private static void make() {
		for(int i=0;i<n+1;i++) {
			parents[i]=i;
		}
	}

}

