package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class BJ16236 {
	private static int n;
	private static int[][] map;
	private static int move = 0;
	private static int[] dirRow = {-1, 0, 0, 1};
	private static int[] dirCol = {0, -1, 1, 0};

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int row = 0, col = 0;

		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					row = i;
					col = j;
				}
			}
		}

		solution(row, col);
		System.out.println(move);
	}

	private static void solution(int row, int col) {
		int size = 2;
		int eat = 0;
		Point point = bfs(row, col, size);
		if (point == null) return;
		++eat;

		while (point != null) {
			point = bfs(point.row, point.col, size);
			++eat;
			if (eat == size) {
				eat = 0;
				++size;
			}
		}
	}

	private static Point bfs(int row, int col, int size) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] isVisited = new boolean[n][n];
		int distance = 0;
		queue.offer(new Point(row, col));

		while (!queue.isEmpty()) {
			int count = queue.size();
			++distance;
			List<Point> list = new ArrayList<>();
			for (int i = 0; i < count; ++i) {
				Point poll = queue.poll();

				for (int j = 0; j < 4; ++j) {
					int nr = poll.row + dirRow[j];
					int nc = poll.col + dirCol[j];
					if (nr < 0 || nc < 0 || nr == n || nc == n || map[nr][nc] > size || isVisited[nr][nc]) continue;

					isVisited[nr][nc] = true;
					if (map[nr][nc] == 0 || map[nr][nc] == size) {
						queue.offer(new Point(nr, nc));
						continue;
					}
					list.add(new Point(nr, nc));
				}
			}
			if (!list.isEmpty()) {
				Collections.sort(list);
				Point point = list.get(0);
				map[row][col] = 0;
				map[point.row][point.col] = 9;
				move += distance;
				return point;
			}
		}
		return null;
	}

	static class Point implements Comparable<Point> {
		int row, col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public int compareTo(Point o) {
			if (row == o.row) {
				return col - o.col;
			}
			return row - o.row;
		}

		@Override
		public String toString() {
			return "row : " + row + ", col : " + col;
		}
	}
}
