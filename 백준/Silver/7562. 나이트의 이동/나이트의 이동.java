import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
	private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	private static StringBuilder sb = new StringBuilder();

	private static void bfs(int len, int row, int col, int goalRow, int goalCol) {
		boolean[][] visited = new boolean[len][len];
		Queue<Point> queue = new LinkedList<>();
		int answer = 0;

		queue.offer(new Point(row, col));
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				Point point = queue.poll();
				if (point.row == goalRow && point.col == goalCol) {
					sb.append(answer).append("\n");
					return;
				}
				for (int j = 0; j < 8; ++j) {
					int nextRow = point.row + dy[j];
					int nextCol = point.col + dx[j];
					if (nextRow < 0 || nextRow >= len || nextCol < 0 || nextCol >= len || visited[nextRow][nextCol])
						continue;
					visited[nextRow][nextCol] = true;
					queue.offer(new Point(nextRow, nextCol));
				}
			}
			++answer;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; ++i) {
			int len = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int goalRow = Integer.parseInt(st.nextToken());
			int goalCol = Integer.parseInt(st.nextToken());
			bfs(len, row, col, goalRow, goalCol);
		}

		System.out.print(sb);
	}

	private static class Point {
		int row, col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
