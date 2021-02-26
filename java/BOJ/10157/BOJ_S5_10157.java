package IM_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 옆으로 두고 생각.
// 우하좌상
public class BOJ_S5_10157_자리배정 {
	static int C, R, K, nr, nc, ir, ic;
	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int cnt = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		C = Integer.parseInt(str[0]);
		R = Integer.parseInt(str[1]);
		K = Integer.parseInt(br.readLine());
		map = new int[C][R];

		recursive(0, -1);
	}

	private static void recursive(int r, int c) {
		if(R*C <cnt+1) {
			System.out.println(0);
			return;
		}
			
		
		nr = r;
		nc = c;
		for (int i = 0; i < 4; i++) {
			while (true) {
				ir = nr;
				ic = nc;
				nr = nr + dr[i];
				nc = nc + dc[i];
				if (nr < 0 || nr >= C || nc < 0 || nc >= R || map[nr][nc] != 0) {
					nr = ir;
					nc = ic;
					break;
				}
				map[nr][nc] = cnt++;
				if (map[nr][nc] == K) {
					System.out.println((nr + 1) + " " + (nc + 1));
					return;
				}
				
			}
		}
		
		recursive(r + 1, c + 1);

	}

}

