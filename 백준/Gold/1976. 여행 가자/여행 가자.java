import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	private static int N, M;
	private static int[] plan;
	private static int[] parents;

	private static void union(int node1, int node2) {
		int parents1 = find(node1);
		int parents2 = find(node2);
		if (parents1 == parents2) {
			return;
		}
		parents[Math.max(parents1, parents2)] = Math.min(parents1, parents2);
	}

	private static int find(int node) {
		if (parents[node] == node) {
			return node;
		}
		return parents[node] = find(parents[node]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		plan = new int[M];
		parents = new int[N + 1];
		IntStream.range(1, N + 1).forEach(i -> parents[i] = i);

		for (int i = 1; i <= N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; ++j) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					union(i, j);
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; ++i) {
			plan[i] = Integer.parseInt(st.nextToken());
		}

		int pivot = find(plan[0]);
		for (int i = 1; i < M; ++i) {
			if (pivot != find(plan[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}
