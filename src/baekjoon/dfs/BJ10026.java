package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class BJ10026 {
	private static int n;
	private static char[][] arr;
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	private static int answer = 0;
	private static boolean[][] visited;
	private static void dfs(int x, int y, char ch) {
		if (ch != arr[y][x]) {
			return ;
		}
		visited[y][x] = true;
		if (arr[y][x] == 'G') arr[y][x] = 'R';
		for (int i = 0; i < 4; ++i) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || visited[nextY][nextX]) continue;
			dfs(nextX, nextY, ch);
		}
	}

	private static void solution() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (visited[i][j]) continue;
				dfs(j, i, arr[i][j]);
				++answer;
			}
		}
		sb.append(answer).append(" ");
		for (boolean[] tmp : visited) {
			Arrays.fill(tmp, false);
		}
		answer = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (visited[i][j]) continue;
				dfs(j, i, arr[i][j]);
				++answer;
			}
		}
		sb.append(answer);
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; ++i) {
			String input = br.readLine();
			for (int j = 0; j < n; ++j) {
				arr[i][j] = input.charAt(j);
			}
		}
		solution();
	}
}
