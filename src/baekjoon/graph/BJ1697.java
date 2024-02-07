package baekjoon.graph;

import java.io.*;
import java.util.*;

public class BJ1697 {
	private static boolean[] visited = new boolean[100001];
	private static int n, k;
	private static int answer;
	private static void solution() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				int poll = queue.poll();
				if (poll == k) {
					return ;
				}
				if (poll + 1 >= 0 && poll + 1 < visited.length && !visited[poll + 1]) {
					queue.offer(poll + 1);
					visited[poll + 1] = true;
				}
				if (poll - 1 >= 0 && poll - 1 < visited.length && !visited[poll - 1]) {
					queue.offer(poll - 1);
					visited[poll - 1] = true;
				}
				if (poll * 2 >= 0 && poll * 2 < visited.length && !visited[poll * 2]) {
					queue.offer(poll * 2);
					visited[poll * 2] = true;
				}
			}
			++answer;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		solution();
		System.out.println(answer);
	}
}
