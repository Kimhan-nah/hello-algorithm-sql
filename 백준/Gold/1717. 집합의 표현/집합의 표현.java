import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	private static int[] parents;
	private static StringBuilder sb = new StringBuilder();

	private static void union(int u, int v) {
		u = find(u);
		v = find(v);
		if (u == v)
			return;
		parents[Math.max(u, v)] = Math.min(u, v);
	}

	private static int find(int v) {
		if (v == parents[v]) {
			return v;
		}
		return parents[v] = find(parents[v]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parents = new int[N + 1];

		IntStream.range(1, N + 1).forEach(i -> parents[i] = i);

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if (command == 0) {
				union(u, v);
			} else if (command == 1) {
				int max = Math.max(u, v);
				int min = Math.min(u, v);
				if (max == min || find(max) == find(min)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}
		System.out.print(sb);
	}

}
