import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_S2_1141_접두사 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}

		Arrays.sort(str);

		int cnt = N;
		for (int i = 0; i < N - 1; i++) {
			int min = Math.min(str[i].length(), str[i + 1].length());
			if (str[i].substring(0, min).equals(str[i + 1].substring(0, min))) {
				cnt--;
			}
		}

//		System.out.println(Arrays.toString(str));
		System.out.println(cnt);

	}

}

