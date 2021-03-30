package com.Boj.Day11;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class BOJ_S2_1713_후보추천하기 {
	static class Student implements Comparable<Student> {
		int no, cnt, time;

		public Student(int no, int cnt, int time) {
			super();
			this.no = no;
			this.cnt = cnt;
			this.time = time;
		}

		@Override
		public int compareTo(Student o) {
			int diff = this.cnt - o.cnt;
			if (diff == 0)
				diff = o.time - this.time;
			return diff;
		}

	}

	static int N, C;
	static ArrayList<Student> arr = new ArrayList<Student>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
//		PriorityQueue<Student> pq=new PriorityQueue<Student>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int tmp;
		for (int i = 0; i < C; i++) {
			tmp = Integer.parseInt(st.nextToken());
			boolean isRemove = true;
			for (Student s : arr) {
				if (s.no == tmp) {
					isRemove = false;
					s.cnt += 1;
					break;
				}
			}

			if (isRemove) {
				if (arr.size() == N) {
					Collections.sort(arr);
					arr.remove(0);
				}
				arr.add(new Student(tmp, 1, 0));
			}
			timeUp();
		}
		Collections.sort(arr,new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.no-o2.no;
			}
		});
		
		print();

	}

	private static void print() {
		for (Student s : arr) {
			System.out.print(s.no+" ");
		}
		
	}

	private static void timeUp() {
		for (Student s : arr) {
			s.time += 1;
		}

	}

}

