import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static List<Edge>[] graph;
	private static boolean[] isVisited;
	private static int answer = Integer.MIN_VALUE;
	private static StringBuilder sb = new StringBuilder();

	private static void dfs(int from, int len) {
		for (Edge edge : graph[from]) {
			if (isVisited[edge.vertex]) {
				continue;
			}
			isVisited[edge.vertex] = true;
			dfs(edge.vertex, len + edge.cost);
		}
		answer = Math.max(answer, len);
	}

	private static void solution() {
		for (int i = 1; i <= N; ++i) {
			Arrays.fill(isVisited, false);
			isVisited[i] = true;
			dfs(i, 0);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new List[N + 1];
		isVisited = new boolean[N + 1];

		// init
		for (int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < N - 1; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[from].add(new Edge(to, cost));
			graph[to].add(new Edge(from, cost));
		}

		solution();

		sb.append(answer);
		System.out.println(answer);
	}

	static class Edge {
		int vertex, cost;

		public Edge(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
	}
}
