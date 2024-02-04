package baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class BJ11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; ++i) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				int max = queue.isEmpty() ? 0 : queue.poll();
				sb.append(max).append("\n");
			} else {
				queue.offer(x);
			}
		}
		System.out.print(sb);
	}
}
