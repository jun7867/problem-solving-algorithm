package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1233_남준영_Ver2 {
	static int N;
	static String[] node;
	static boolean isValid;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=10;
		StringTokenizer st = null;
		for(int tc=1;tc<=10;tc++) {
			isValid=true;
			N=Integer.parseInt(br.readLine());
			node=new String[N+1];
			for(int i=1;i<=N;i++) {
				st=new StringTokenizer(br.readLine()," ");
				int parent=Integer.parseInt(st.nextToken());
				node[i]=st.nextToken();
				
			}
			
			dfs(1);
			if(isValid)
				System.out.printf("#%d %d\n",tc,1);
			else {
				System.out.printf("#%d %d\n",tc,0);
			}
		}
	}
	private static void dfs(int idx) {
		// 자식이 없으면 끝.
		if(idx*2 > N || idx*2+1 > N)
			return;
		dfs(idx*2);
		dfs(idx*2+1);
		
		//자식이 부호면 안됨.
		if(isOp(idx*2) && isOp(idx*2+1)) {
			isValid=false;
			return ;
		}
		
		if(isOp(idx)) {
			// L+R 계산했다고 가정.
			node[idx]="1";
		}else {
			isValid=false;
			return ;
		}
		
	}
	private static boolean isOp(int idx) {
		if(node[idx].equals("+") || node[idx].equals("-") || node[idx].equals("*") || node[idx].equals("/")) {
			return true;
		}
		
		return false;
	}
}

