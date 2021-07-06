import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// a의 갯수를 구하고, 0부터 마지막까지 a의 길이만큼 돌면서 b의 교환 최소 횟수를 찾는다. 
// 양 끝이 연결되어있기 때문에 마지막 인덱스까지 길이만큼 % 해줘야함.
public class BOJ_G5_1522_문자열교환 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int cnt = 0;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == 'a')
				cnt++;
		}

		int min = len;
		int bcnt = 0;
		for (int i = 0; i < len; i++) {
			bcnt = 0;
			// a의 길이만큼 + i범위 추가로 확인
			for (int j = i; j < cnt + i; j++) {
				if (str.charAt(j % len) == 'b')
					bcnt++;
			}
			min = Math.min(min, bcnt);
		}
		System.out.println(min);
	}

}

