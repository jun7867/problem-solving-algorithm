package SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * NxN 칸에 M마리의 상어 존재, 각 상어는 번호 부여되어있음 상어는 자신이 있는 칸에 본인의 냄새 뿌림 냄새 뿌린 후 동, 서, 남, 북
 * 방향으로 이동 이동 경로 탐색 순서는 각 상어가 바라보고 있는 방향에 따라 우선순위 존재 : 우선순위 방향대로 이동 우선순위는 상어마다
 * 다름 우선순위가 같은 상어라도 현재 상어가 보고 있는 방향에 따라 또 다름 빈칸이 있으면 빈칸으로 이동 빈칸이 없으면, 자신의 냄새가 있는
 * 칸의 방향으로 이동 냄새가 있는 칸이 여러 개이면 : 특정한 우선순위를 따름 만약 같은 칸에 한마리 이상의 상어가 도착했을 때, 상어
 * 번호가 더 작은 상어만이 살아남음 1번 상어만 살아남게되는 시간 출력 1,000초가 넘어도 다른 상어가 격자에 남아 있으면 -1을 출력
 *
 */
public class BOJ_G3_19237_어른상어 {
	static int N, M, K;
	static int[][][] map;
	static int time = 0;
	static int[] dr = { 0, -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, 0, -1, 1 };
	static Shark[] shark;
	static int out=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N][2]; // 0 은 map정보, 1은 smell 정보
		shark = new Shark[M + 1]; // 상어 정보 저장

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num != 0) {
					shark[num] = new Shark(i, j, true);
					map[i][j][0] = num;
					map[i][j][1] = K; // K초까지 냄새가 남아있음
				}
			}
		}

		// 상어의 방향 정보 저장
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= M; i++) {
			shark[i].dir = Integer.parseInt(st.nextToken());
		}

		// 상어 우선순위 저장
		for (int n = 1; n <= M; n++) {
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= 4; j++) {
					shark[n].prio_dir[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		process();
		System.out.println(time);
	}

	private static void process() {

		// 1000초까지만 진행 <=하면 틀리네? 
		while (time < 1000) {
			time++;

			// 모든 상어 이동
			move();
			
			smellRemove();
			outShark();
			smell();
			
			if(out == M-1)
				return;
		}
		time=-1;

	}

	// 냄새 남기기
	private static void smell() {
		for (int i = 1; i <=M; i++) {
			if(!shark[i].isAlive) continue;
			
			map[shark[i].r][shark[i].c][0]=i;
			map[shark[i].r][shark[i].c][1]=K;
		}
		
	}

	private static void outShark() {
		for (int i = M; i>0; i--) {
			if(!shark[i].isAlive)
				continue;
			
			// i보다 작은 숫자의 샤크
			for (int j = 1; j < i; j++) {
				if(!shark[j].isAlive)
					continue;
				if(shark[i].r == shark[j].r && shark[i].c == shark[j].c) {
					shark[i].isAlive=false; // 샤크 사망
					out++;
					break;
				}
			}
		}
		
	}

	private static void smellRemove() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j][1] >0)
					map[i][j][1]--;
				if(map[i][j][1]==0)
					map[i][j][0]=0;
			}
		}
		
	}

	private static void move() {
		for (int i = 1; i <= M; i++) {
			Shark cur = shark[i];
			if (!cur.isAlive)
				continue; // 쫓겨났다면 pass

			int[] pri_dir = cur.prio_dir[cur.dir];
			boolean notSmell = false; // 주변 냄새 안나는 칸 확인
			int nr=0,nc=0;
			Shark tmp=new Shark(0, 0, true);
			
			// 1. 냄새가 없는 칸 => 2순위 : 자신의 냄새가 있는 칸 (우선순위)
			for (int d = 1; d <= 4; d++) {
				int priD = pri_dir[d];
				nr = cur.r + dr[priD];
				nc = cur.c + dc[priD];

				if (!canMove(nr, nc))
					continue;
				// 냄새가 있으면 냄새 우선순위 저장하고 pass 
				if (map[nr][nc][1] != 0) {
					if(map[nr][nc][0] !=i) continue; // 내 냄새가 아니면 어차피 못감
					if(!notSmell) { // false일때.. 맨 처음 냄새 찾았을때
						notSmell=true; // 우선순위 처음 냄새만 저장
						tmp.r= nr;
						tmp.c= nc;
						tmp.dir=pri_dir[d];
						continue;
					}
					continue;
				}
				// 여기까지 왔다면 냄새가 없는 칸이 있어서 그곳으로 이동 가능
				notSmell = false;
				cur.r= nr;
				cur.c= nc;
				cur.dir=pri_dir[d];
				break;
			}
			// 빈칸이 없어서 저장했던 임시 냄새칸으로 이동
			if(notSmell) {
				cur.r=tmp.r;
				cur.c=tmp.c;
				cur.dir=tmp.dir;
			}
		}
	}

	private static boolean canMove(int r, int c) {
		return (r >= 0 && r < N && c >= 0 && c < N);
	}

	static class Shark {
		int r, c, dir;
		boolean isAlive;
		int[][] prio_dir = new int[5][5];

		public Shark(int r, int c, boolean isAlive) {
			super();
			this.r = r;
			this.c = c;
			this.isAlive = isAlive;
		}
	}
}

