import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt=0;
		boolean isValid=true;
		while(N>0) {
			if(N%5 !=0) {
				N-=3;
				cnt++;
				if(N<0) {
					isValid=false;
					break;
				}
			}else {
				N-=5;
				cnt++;
			}
		}
		if(isValid) System.out.println(cnt);
		else	System.out.println(-1);
		
		
	}

}
