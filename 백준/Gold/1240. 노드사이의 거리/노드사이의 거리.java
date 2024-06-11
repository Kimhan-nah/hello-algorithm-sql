import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static int N, M;
	private static int[] dis;
	private static List<Edge>[] graph;

	private static int solution(int start, int end) {
		Queue<Edge> queue = new PriorityQueue<>();
		dis[start] = 0;
		queue.offer(new Edge(start, 0));

		while (!queue.isEmpty()) {
			Edge now = queue.poll();
			if (now.distance > dis[now.vertex]) {
				continue;
			}
			for (Edge edge : graph[now.vertex]) {
				if (now.distance + edge.distance < dis[edge.vertex]) {
					dis[edge.vertex] = now.distance + edge.distance;
					queue.offer(new Edge(edge.vertex, dis[edge.vertex]));
				}
			}
		}
		return dis[end];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dis = new int[N + 1];
		graph = new List[N + 1];
		for (int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			graph[node1].add(new Edge(node2, distance));
			graph[node2].add(new Edge(node1, distance));
		}
		for (int i = 0; i < M; ++i) {
			Arrays.fill(dis, Integer.MAX_VALUE);
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int distance = solution(node1, node2);
			sb.append(distance).append("\n");
		}
		System.out.print(sb);
	}

	private static class Edge implements Comparable<Edge> {
		int vertex, distance;

		public Edge(int vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge o) {
			return this.distance - o.distance;
		}
	}
}
