package sinhan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// LCA (최소 공통 조상) => depth를 맞춰주고 증가시키면서 비교
// dfs
public class BOJ_G4_3584_가장가까운공통조상 {
	static int N, a, b;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			parents = new int[N + 1];

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				parents[b] = a;
			}
			// 공통 조상을 찾는 두 노드
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			int a_depth = get_depth(a);
			int b_depth = get_depth(b);

			int same = solve(a, a_depth, b, b_depth);
			System.out.println(same);

		}

	}

	static int solve(int a, int a_depth, int b, int b_depth) {
		// 둘의 depth가 같아질 때까지 위로 올린다.
		if (a_depth > b_depth) {
			while (a_depth != b_depth) {
				a_depth--;
				a = parents[a];
			}
		} else if (a_depth < b_depth) {
			while (a_depth != b_depth) {
				b_depth--;
				b = parents[b];
			}
		}

		while (a != b) {
			a = parents[a];
			b = parents[b];
		}

		return a;
	}

	static int get_depth(int n) {
		int depth = 0;
		int cur = n;
		while (cur != 0) {
			depth++;
			cur = parents[cur];
		}
		return depth - 1;
	}

}

