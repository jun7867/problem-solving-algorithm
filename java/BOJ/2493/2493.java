package com.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G5_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();

		for (int i = 1; i <= N; i++) {
			int curTower=Integer.parseInt(st.nextToken());
			if(i==1) {
				stack.push(curTower);
				index.push(i);
				System.out.print(0+" ");
				continue;
			}
			while(!stack.isEmpty()) {
				if(stack.peek() > curTower) {
					System.out.print(index.peek()+" ");
					break;
				}
				stack.pop();
				index.pop();
			}
			if(stack.isEmpty()) {
				System.out.print(0+" ");
			}
			stack.push(curTower);
			index.push(i);				
		}
	}

}

