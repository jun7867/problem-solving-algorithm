package D2;
import java.io.*;
import java.util.StringTokenizer;

public class D2_1948 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] date = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //월별 일수를 미리 저장
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m1 = Integer.parseInt(st.nextToken())-1;
			int d1 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken())-1;
			int d2 = Integer.parseInt(st.nextToken());
			
			
			int sum = date[m1]-d1+1; //첫 번째 달을 합에 미리 저장
            
            //두 번째 달부터 마지막 달까지 모두 합해준다.
			for(int i=m1+1; i<=m2; i++) {
				sum += date[i];
			}
            
            //마지막 달의 일수에서 입력받은 두 번째 일수를 빼준 값을 총 합에서 빼준다.
			sum -= date[m2]-d2;
            
			System.out.println("#"+tc+" "+sum);
		}
	}

}
