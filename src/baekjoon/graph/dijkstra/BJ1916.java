package baekjoon.graph.dijkstra;

import java.io.*;
import java.util.*;

public class BJ1916 {
	private static int N, M;
	private static List<Edge>[] graph;
	private static int[] dp;

	private static void solution(int from, int to) {
		Queue<Edge> pq = new PriorityQueue<>();

		dp[from] = 0;
		for (Edge edge : graph[from]) {
			pq.offer(edge);
		}

		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			dp[now.vex] = Math.min(dp[now.vex], now.cost);
			if (now.vex == to) break;
			for (Edge edge : graph[now.vex]) {
				if (dp[edge.vex] <= dp[now.vex] + edge.cost) continue;
				pq.offer(new Edge(edge.vex, dp[now.vex] + edge.cost));
			}
		}
		System.out.println(dp[to]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new List[N + 1];
		dp = new int[N + 1];
		for (int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<>();
		}
		Arrays.fill(dp, Integer.MAX_VALUE);

		for (int i = 0; i < M; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[from].add(new Edge(to, cost));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		solution(from, to);
	}

	static class Edge implements Comparable<Edge> {
		int vex, cost;

		public Edge(int vex, int cost) {
			this.vex = vex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
}
