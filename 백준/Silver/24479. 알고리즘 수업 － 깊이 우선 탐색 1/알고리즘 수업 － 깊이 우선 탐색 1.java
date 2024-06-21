import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, R;
	private static List<Integer>[] graph;
	private static int[] answer;
	private static int sequence = 0;
	private static boolean[] isVisited;
	private static StringBuilder sb = new StringBuilder();

	private static void dfs(int vertex) {
		isVisited[vertex] = true;
		answer[vertex] = ++sequence;
		for (int adjacent : graph[vertex]) {
			if (!isVisited[adjacent]) {
				dfs(adjacent);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		graph = new List[N + 1];
		answer = new int[N + 1];
		isVisited = new boolean[N + 1];

		// init
		for (int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= N; ++i) {
			Collections.sort(graph[i]);
		}

		dfs(R);

		for (int i = 1; i <= N; ++i) {
			sb.append(answer[i]).append("\n");
		}
		System.out.print(sb);
	}
}
