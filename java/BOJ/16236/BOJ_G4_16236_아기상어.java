package a_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_16236_아기상어 {
	static int N;
	static int[][] map;
	static int[] dr= {-1,0,0,1}; // 상좌우하 
	static int[] dc= {0,-1,1,0};
	static boolean[][] visit;
	static int time=0;
	static PriorityQueue<Shark> q;
	static int sharkBody=2;
	static int eat=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		StringTokenizer st;
		q = new PriorityQueue<Shark>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					q.add(new Shark(i,j,0));
					map[i][j]=0;
				} 
			}
		}
		
		bfs();
		System.out.println(time);
		

	}

	private static void bfs() {
		while(!q.isEmpty()) {
			Shark s=q.poll(); // 현재 상어의 위치
			
			for(int i=0;i<4;i++) {
				int nr=s.r+dr[i];
				int nc=s.c+dc[i];
				
				if(nr >=0 && nr<N && nc >=0 && nc<N && !visit[nr][nc]) {
					visit[nr][nc]=true;
					if(map[nr][nc] <=sharkBody)
						q.add(new Shark(nr,nc,s.d+1));
				}
			}
			
			// 이동가능한 shark 위치
			if(!q.isEmpty()) {
				Shark cur = q.peek();
	
				// 잡아먹을 수 있다면
				if(map[cur.r][cur.c] >0 && map[cur.r][cur.c] < sharkBody) {
					eat++;
					if(eat==sharkBody) {
						eat=0;
						sharkBody++;
					}
					map[cur.r][cur.c]=0;
					
					// 초기화 및 상어 위치 이동 
					q.clear();
					q.add(new Shark(cur.r,cur.c,0));
					time+=cur.d;
					visit=new boolean[N][N];
					visit[cur.r][cur.c]=true;
					
				}
			}
			
		}
		
	}

}

class Shark implements Comparable<Shark>{
	int r, c,d;

	public Shark(int r, int c, int d) {
		super();
		this.r = r;
		this.c = c;
		this.d = d;
	}

	@Override
	public int compareTo(Shark o) {
		int diff = this.d-o.d;
		if(diff==0) {
			diff=this.r-o.r;
			if(diff==0) {
				diff=this.c-o.c;
			}
		}
		return diff;
	}

}
