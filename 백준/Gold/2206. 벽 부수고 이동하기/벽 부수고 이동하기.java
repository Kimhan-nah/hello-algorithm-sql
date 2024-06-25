import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[][] map;
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int answer = Integer.MAX_VALUE;

	private static void bfs(int startRow, int startCol, int endRow, int endCol) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		int distance = 0;
		queue.offer(new Point(startRow, startCol, false));

		while (!queue.isEmpty()) {
			int size = queue.size();
			++distance;
			for (int i = 0; i < size; ++i) {
				Point point = queue.poll();

				if (point.row == endRow && point.col == endCol) {
					answer = Math.min(answer, distance);
					return;
				}
				if (visited[point.row][point.col]) {
					continue;
				}
				visited[point.row][point.col] = true;
				for (int j = 0; j < 4; ++j) {
					int nextRow = point.row + dy[j];
					int nextCol = point.col + dx[j];
					if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M || visited[nextRow][nextCol]) {
						continue;
					}
					if (map[nextRow][nextCol] == 1 && !point.isBroken) {
						queue.offer(new Point(nextRow, nextCol, true));
					} else if (map[nextRow][nextCol] == 0) {
						queue.offer(new Point(nextRow, nextCol, point.isBroken));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; ++i) {
			String row = br.readLine();
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
			}
		}

		bfs(0, 0, N - 1, M - 1);
		bfs(N - 1, M - 1, 0, 0);

		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}

	private static class Point {
		int row, col;
		boolean isBroken;

		public Point(int row, int col, boolean isBroken) {
			this.row = row;
			this.col = col;
			this.isBroken = isBroken;
		}
	}
}
