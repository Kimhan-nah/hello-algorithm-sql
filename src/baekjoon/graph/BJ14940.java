package baekjoon.graph;

import java.io.*;
import java.util.*;

public class BJ14940 {
	private static int n, m;
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {-1, 1, 0, 0};
	private static int[][] map;
	private static int[][] answer;

	private static void solution(int goalRow, int goalCol) {
		Queue<Point> queue = new LinkedList<>();
		int distance = 1;

		queue.offer(new Point(goalCol, goalRow));

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; ++i) {
				Point point = queue.poll();
				for (int j = 0; j < 4; ++j) {
					int x = point.x + dx[j];
					int y = point.y + dy[j];
					if (x < 0 || y < 0 || x >= m || y >= n || answer[y][x] != -1) continue;
					answer[y][x] = distance;
					queue.offer(new Point(x, y));
				}
			}
			++distance;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		answer = new int[n][m];
		int goalRow = 0;
		int goalCol = 0;

		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(answer[i], -1);
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					goalRow = i;
					goalCol = j;
					answer[goalRow][goalCol] = 0;
				} else if (map[i][j] == 0) {
					answer[i][j] = 0;
				}
			}
		}

		solution(goalRow, goalCol);

		// print
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				sb.append(answer[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);

	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
