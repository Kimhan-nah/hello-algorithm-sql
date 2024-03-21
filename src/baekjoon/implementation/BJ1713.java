package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class BJ1713 {
	private static int n, total;
	private static int[] votes;
	private static int order = 0;

	private static Student findStudent(Queue<Student> coordinates, int vote) {
		for (Student coordinate : coordinates) {
			if (coordinate.num == vote) {
				return coordinate;
			}
		}
		return null;
	}

	private static void solution() {
		Queue<Student> coordinates = new PriorityQueue<>();

		for (int vote : votes) {
			Student student = findStudent(coordinates, vote);
			if (student != null) {
				coordinates.offer(new Student(student.num, student.count + 1, student.order));
				coordinates.remove(student);
				continue;
			}
			if (coordinates.size() == n) {
				coordinates.poll();
			}
			coordinates.offer(new Student(vote, 1, ++order));
		}

		List<Integer> answer = new ArrayList<>();
		for (Student coordinate : coordinates) {
			answer.add(coordinate.num);
		}
		Collections.sort(answer);
		StringBuilder sb = new StringBuilder();
		for (int a : answer) {
			sb.append(a).append(" ");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		total = Integer.parseInt(br.readLine());
		votes = new int[total];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < total; ++i) {
			votes[i] = Integer.parseInt(st.nextToken());
		}

		solution();
	}

	static class Student implements Comparable<Student> {
		int num;
		int count;
		int order;

		public Student(int num, int count, int order) {
			this.num = num;
			this.count = count;
			this.order = order;
		}

		@Override
		public int compareTo(Student o) {
			if (this.count == o.count) {
				return this.order - o.order;
			}
			return this.count - o.count;
		}
	}

}
