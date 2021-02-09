package com.ssafy.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S5_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		Queue<Integer> queue= new LinkedList<Integer>();
		
		for(int i=1;i<=N;i++) {
			queue.add(i);
		}
		sb.append("<");
		int count=1;
		while(!queue.isEmpty()) {
			if(count++ % K ==0) {
				sb.append(queue.poll()+", ");
			}else {
				int temp=queue.poll();
				queue.offer(temp);
			}
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());

	}

}

