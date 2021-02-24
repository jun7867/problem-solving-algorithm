package IM_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_B2_2309_일곱난쟁이 {
	// 조합!
	static int[] numbers=new int[7];
	static int[] dwarf= new int[9];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;i++) {
			dwarf[i]=Integer.parseInt(br.readLine());
		}
		
		combination(0,0);
	}
	private static void combination(int idx,int start) {
		if(idx==7) {
			int sum=0;
			for(int h : numbers) {
				sum+=h;
			}
			if(sum==100) {
				Arrays.sort(numbers);
				for(int n : numbers)
					System.out.println(n);
			}
			return;
		}
		
		for(int i=start;i<9;i++) {
			numbers[idx]=dwarf[i];
			combination(idx+1, i+1);
		}
		
		
	}

}

