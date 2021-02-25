package IM_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pair {
	int r, c, d;

	public Pair(int r, int c, int d) {
		this.r = r;
		this.c = c;
		this.d = d;
	}
}

public class BOJ_S1_2564_경비원 {

	static int W, H, N, min, sum, d, p;
	static int r, c;
	static List<Pair> Store, Dongen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		Store = new ArrayList<Pair>();
		Dongen = new ArrayList<Pair>();
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			d = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			position();
			if (i == N)
				Dongen.add(new Pair(r, c, d));
			else
				Store.add(new Pair(r, c, d));
		}
		sum=0;
		sol();
		System.out.println(sum);
	}

	private static void sol() {
		int dr = Dongen.get(0).r;
		int dc = Dongen.get(0).c;
		int dd = Dongen.get(0).d;

		for (Pair s : Store) {
			// 서로 마주볼때
			if((dd == 1 && s.d==2) ||(dd==2 && s.d==1) || (dd==3 && s.d==4) || (dd==4 && s.d==3)) {
				int case1=0,case2=0;
				if(d==1 || d==2) { // 남북  +시계 
					case1=H + (W-dc)+(W-s.c);
				} else { // 동서 시계 
					case1=W + (H-dr)+(H-s.r);
				}
				case2=dr+dc+s.r+s.c; // 반시계 
				sum+= Math.min(case1, case2);
			} else {
				sum+=Math.abs(dr-s.r)+Math.abs(dc-s.c);
			}
		}

	}

	private static void position() {
		if (d == 1) { 
			r = 0;
			c = p;
		} else if (d == 2) {
			r = H ;
			c = p;
		} else if (d == 3) {
			r = p;
			c = 0;
		} else if (d == 4) {
			r = p;
			c = W;
		}

	}

}

