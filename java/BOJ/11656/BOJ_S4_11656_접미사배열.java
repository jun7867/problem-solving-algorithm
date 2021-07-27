package com.ssafy.heap;

public class BOJ_S4_11656_접미사배열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		for (int i = 0; i < str.length(); i++) {
			pq.add(str.substring(i));
		}

		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}

	}

}

