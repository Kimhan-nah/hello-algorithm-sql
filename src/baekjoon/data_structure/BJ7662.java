package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class BJ7662 {
	private static StringBuilder sb = new StringBuilder();

	private static void printResult(Map<Integer, Integer> map) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int size = 0;
		for (Integer key : map.keySet()) {
			if (map.get(key) <= 0) continue;
			max = Math.max(max, key);
			min = Math.min(min, key);
			++size;
		}
		if (size == 0) {
			sb.append("EMPTY\n");
			return;
		}
		sb.append(max).append(" ").append(min).append("\n");
	}

	private static void removeQueue(Queue<Integer> queue, Map<Integer, Integer> map) {
		while (true) {
			Integer key = queue.poll();
			if (key == null) return;
			if (map.containsKey(key)) {
				int value = map.get(key);
				if (value <= 1)
					map.remove(key);
				else
					map.put(key, value - 1);
				return;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; ++i) {
			int k = Integer.parseInt(br.readLine());
			Map<Integer, Integer> map = new HashMap<>();
			Queue<Integer> queue = new PriorityQueue<>();		// 작은거부터 (오름차순)
			Queue<Integer> reversQueue = new PriorityQueue<>(Comparator.reverseOrder());	// 큰거부터 (내림차순)
			for (int j = 0; j < k; ++j) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int n = Integer.parseInt(st.nextToken());

				if ("I".equals(cmd)) {
					map.put(n, map.getOrDefault(n, 0) + 1);
					queue.offer(n);
					reversQueue.offer(n);
				} else if ("D".equals(cmd)) {
					if (map.isEmpty()) continue;
					if (n == 1) {
						removeQueue(reversQueue, map);
					} else {
						removeQueue(queue, map);
					}
				}
			}
			printResult(map);
		}
		System.out.print(sb);
	}
}
