package baekjoon.graph;

import java.io.*;
import java.util.*;

public class BJ16928 {
	private static int N, M;	// N 사다리, M 뱀
	private static int[] graph;
	private static boolean[] visited;

	private static int solution() {
		Queue<Integer> queue = new LinkedList<>();
		int level = 0;

		queue.offer(1);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				int poll = queue.poll();
				if (poll == 100) return level;
				for (int j = 1; j <= 6; ++j) {
					int next = poll + j;
					if (next > 100 || visited[next]) continue;
					next = graph[next] > 0 ? graph[next] : next;
					visited[next] = true;
					queue.offer(next);
				}
			}
			++level;
		}
		return level;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[101];
		visited = new boolean[101];

		for (int i = 0; i < N + M; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x] = y;
		}

		int answer = solution();
		System.out.println(answer);
	}
}
