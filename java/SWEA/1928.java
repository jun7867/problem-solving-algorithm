package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

public class D2_1928 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			String encoded = br.readLine();
			String decoded=new String(Base64.getDecoder().decode(encoded));
			System.out.println("#"+tc+" "+decoded);
		}

	}

}

