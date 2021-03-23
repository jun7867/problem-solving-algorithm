package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	static int n,m;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		parent= new int[n+1];
		int a,b;
		make();
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		int cnt=0;
		
		for(int i=1;i<n+1;i++) {
			if(i==parent[i])
				cnt++;
		}
		System.out.println(cnt);

	}
	private static int find(int a) {
		if(parent[a]==a) return a;
		
		return parent[a]=find(parent[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot==bRoot) return false;
		
		parent[bRoot]=aRoot;
		return true;
		
	}
	private static void make() {
		for(int i=0;i<n+1;i++)
			parent[i]=i;
	}
	

}

