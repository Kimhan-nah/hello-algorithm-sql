import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[][] map;
	private static int[][] dp;
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};

	private static int dfs(int row, int col) {
		if (row == N - 1 && col == M - 1) {
			return 1;
		}
		if (dp[row][col] != -1) {
			return dp[row][col];
		}

		dp[row][col] = 0;

		for (int i = 0; i < 4; ++i) {
			int nextRow = row + dy[i];
			int nextCol = col + dx[i];
			if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M)
				continue;

			if (map[nextRow][nextCol] < map[row][col]) {
				dp[row][col] += dfs(nextRow, nextCol);
			}
		}
		return dp[row][col];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[i], -1);
		}

		int answer = dfs(0, 0);

		System.out.println(answer);
	}
}
