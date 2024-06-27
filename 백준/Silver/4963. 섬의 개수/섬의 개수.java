import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int width, height;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
	private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	private static StringBuilder sb = new StringBuilder();

	private static void dfs(int row, int col) {
		visited[row][col] = true;

		for (int i = 0; i < 8; ++i) {
			int nextRow = row + dy[i];
			int nextCol = col + dx[i];
			if (nextRow < 0 || nextRow >= height || nextCol < 0 || nextCol >= width)
				continue;
			if (!visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
				dfs(nextRow, nextCol);
			}
		}
	}

	private static int solution() {
		int answer = 0;

		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				if (map[i][j] == 1 && !visited[i][j]) {
					dfs(i, j);
					++answer;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			if (width == 0 && height == 0) {
				break;
			}
			map = new int[height][width];
			visited = new boolean[height][width];
			for (int i = 0; i < height; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < width; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = solution();
			sb.append(answer).append("\n");
		}

		System.out.print(sb);
	}
}
