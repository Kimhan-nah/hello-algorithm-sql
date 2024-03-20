package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class BJ13335 {
	private static int n, w, L;
	private static Queue<Integer> queue = new LinkedList<>();
	private static int answer = 0;

	private static void solution() {
		Queue<Integer> current = new LinkedList<>();
		int weight = 0;

		for (int i = 0; i < w; ++i) {
			current.offer(0);
		}

		while (!current.isEmpty()) {
			int out = current.poll();
			weight -= out;
			if (!queue.isEmpty() && weight + queue.peek() > L) {
				current.offer(0);
			} else if (!queue.isEmpty() && weight + queue.peek() <= L) {
				int in = queue.poll();
				current.offer(in);
				weight += in;
			}
			++answer;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}
		solution();
		System.out.println(answer);
	}
}
