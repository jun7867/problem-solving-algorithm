package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1141 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		long sum=0;
		int N=Integer.parseInt(br.readLine());
		
		for(int i=1;i<=N;i++) {
			int curCow=Integer.parseInt(br.readLine());
			while(!stack.isEmpty()) {
				if(stack.peek() <= curCow) {
					stack.pop(); // 나보다 키가 크면 못보니까 제거.
				} else {
					sum+=stack.size(); // 이 소를 볼 수 있는 소들이 stack에 쌓여있으니까 stack만큼 더해주면 이 소를 볼 수 있는 이전 소들의 수 + !!
					break;
				}
				
			}
			stack.push(curCow); 
		}
		System.out.println(sum);
	}

}

