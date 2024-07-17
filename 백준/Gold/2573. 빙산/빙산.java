import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[][] arr;
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};

	private static void dfs(boolean[][] visited, int row, int col) {
		visited[row][col] = true;

		// 동서남북 확인하고 인접한 빙산 dfs 호출
		for (int k = 0; k < 4; ++k) {
			int nextRow = row + dy[k];
			int nextCol = col + dx[k];
			if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M)
				continue;
			if (arr[nextRow][nextCol] > 0 && !visited[nextRow][nextCol])
				dfs(visited, nextRow, nextCol);
		}
	}

	/**
	 * 끝나지 않을 경우 -> 0
	 * 끝날 경우 : 다 녹을 경우 (1) || 2덩이 이상일 경우 (2)
	 */
	private static int isFinished() {
		int count = 0;
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (arr[i][j] > 0 && !visited[i][j]) {
					if (count > 0) {
						return 2;
					}
					dfs(visited, i, j);
					++count;
				}
			}
		}
		return count == 0 ? 1 : 0;
	}

	/**
	 * 빙산 녹이기
	 */
	private static void melt() {
		int[][] tmp = new int[N][M];

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (arr[i][j] == 0)
					continue;

				// 동서남북 확인하고, 0이면 카운트
				int count = 0;
				for (int k = 0; k < 4; ++k) {
					int nextRow = i + dy[k];
					int nextCol = j + dx[k];
					if (nextCol < 0 || nextCol >= M || nextRow < 0 || nextRow >= N)
						continue;
					if (arr[nextRow][nextCol] == 0)
						++count;
				}
				tmp[i][j] = Math.max(arr[i][j] - count, 0);
			}
		}
		arr = tmp;
	}

	private static int solution() {
		int count = 0;
		while (true) {
			int finished = isFinished();
			if (finished == 1) {
				return 0;
			} else if (finished == 2) {
				return count;
			}
			melt();
			++count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = solution();
		System.out.println(answer);
	}
}
