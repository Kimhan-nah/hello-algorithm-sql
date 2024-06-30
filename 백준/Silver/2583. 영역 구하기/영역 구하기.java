import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int M, N, K;
	private static boolean[][] map;
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static List<Integer> answers = new ArrayList<>();
	private static StringBuilder sb = new StringBuilder();

	private static int dfs(int row, int col) {
		int count = 1;
		map[row][col] = true;

		for (int i = 0; i < 4; ++i) {
			int nextRow = row + dy[i];
			int nextCol = col + dx[i];
			if (nextRow < 0 || nextRow >= M || nextCol < 0 || nextCol >= N || map[nextRow][nextCol])
				continue;
			count += dfs(nextRow, nextCol);
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[M][N];

		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int j = M - y2; j < M - y1; ++j) {
				for (int k = x1; k < x2; ++k) {
					map[j][k] = true;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < M; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!map[i][j]) {
					int size = dfs(i, j);
					++count;
					answers.add(size);
				}
			}
		}
		Collections.sort(answers);
		sb.append(count).append("\n");
		answers.forEach(answer -> sb.append(answer).append(" "));
		System.out.println(sb);
	}

}
