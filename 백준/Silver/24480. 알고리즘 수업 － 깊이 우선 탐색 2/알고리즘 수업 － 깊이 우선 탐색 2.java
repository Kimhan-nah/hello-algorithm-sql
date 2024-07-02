import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static Queue<Integer>[] graph;
	private static int[] visit;
	private static int count = 1;
	private static StringBuilder sb = new StringBuilder();

	private static void dfs(int vertex) {
		visit[vertex] = count++;

		while (!graph[vertex].isEmpty()) {
			int next = graph[vertex].poll();
			if (visit[next] != 0)
				continue;
			dfs(next);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		graph = new PriorityQueue[N + 1];
		visit = new int[N + 1];

		// init
		for (int i = 0; i <= N; ++i) {
			graph[i] = new PriorityQueue<>(Comparator.reverseOrder());
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].offer(v);
			graph[v].offer(u);
		}
		dfs(start);

		for (int i = 1; i <= N; ++i) {
			sb.append(visit[i]).append("\n");
		}
		System.out.print(sb);
	}

}
