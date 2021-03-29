package com.Boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_S1_16953_AB {
	static class Node {
		long n;
		int cnt;

		public Node(long n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		boolean isValid = false;

		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(A, 0));

		int cnt = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (cur.n == B) {
				isValid = true;
				cnt = cur.cnt;
				break;
			}

			if (cur.n < B) {
				q.add(new Node(cur.n * 2, cur.cnt + 1));
				q.add(new Node(cur.n * 10 + 1, cur.cnt + 1));

			}
		}

		if (isValid)
			System.out.println(cnt + 1);
		else
			System.out.println(-1);

	}

}

