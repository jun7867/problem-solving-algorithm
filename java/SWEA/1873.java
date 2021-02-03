package D3;

import java.util.Scanner;
// SWEA 1873 배틀필드 
// 시물레이션 
public class Main_1873_남준영 {
	//상하좌우 
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int d=0;
	static Character[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int H=sc.nextInt();
			int W=sc.nextInt();
			int x=0;
			int y=0;
			int nx,ny=0;
			map=new Character[H][W];
			for(int i=0;i<H;i++) {
				String temp=sc.next();
				for(int j=0;j<W;j++) {
					map[i][j]=temp.charAt(j);
					if(map[i][j]=='<' || map[i][j]=='^' || map[i][j]=='v' || map[i][j]=='>') {
						if(map[i][j] =='^')
							d=0;
						else if(map[i][j] =='v')
							d=1;
						else if(map[i][j]=='<')
							d=2;
						else
							d=3;
						x=i;
						y=j;
					}		
				}
			}
			int N = sc.nextInt();
			String command=sc.next();
			
			for(int i=0;i<N;i++) {
				Character com=command.charAt(i);
				
				if(com=='S') { // 포탄 발사
					
					int c=1;
					while(true){
						nx=x+(dx[d]*c);
						ny=y+(dy[d]*c);
						if(nx <0 || nx >=H || ny<0 || ny>=W)
							break;
						if(map[nx][ny]=='#')
							break;
						else if(map[nx][ny]=='*') {
							map[nx][ny]='.';
							break;
						}
						
						c++;
					}
					
					
				} else { // 이동
					changeDirection(com,x,y);
					nx=x+dx[d];
					ny=y+dy[d];
					// 범위 초과로 이동 불가 상태.
					if(nx <0 || nx >=H || ny<0 || ny>=W)
						continue;
					
					if(map[nx][ny] =='.') { //평지면
						map[nx][ny]=map[x][y]; // 전차 이동.
						map[x][y]='.'; // 기존 위치 평지로 바꿈.
						x=nx; // 이동 위치 저장.
						y=ny;
					}
					
				}
				
				
			}
			// 출력! 
			System.out.printf("#%d ",tc);
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}
	// 방향 전차 바꿔주기
	private static void changeDirection(Character com,int x,int y) {
		if (com=='U') {
			map[x][y]='^';
			d=0;
		}else if(com=='D') {
			map[x][y]='v';
			d=1;
		}else if(com=='L') {
			map[x][y]='<';
			d=2;
		}else if(com=='R') {
			map[x][y]='>';
			d=3;
		}
			
		
		return;
	}

}

