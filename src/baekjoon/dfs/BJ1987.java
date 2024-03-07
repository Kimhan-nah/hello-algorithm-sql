package baekjoon.dfs;

import java.io.*;
import java.util.*;

public class BJ1987 {
	private static int r, c;
	private static char[][] arr;
	private static boolean[][] isVisited;
	private static boolean[] alphabet = new boolean[26];
	private static final int[] dx = {1, 0, -1, 0};
	private static final int[] dy = {0, 1, 0, -1};
	private static int answer = 0;

	private static void dfs(int row, int col, int count) {
		if (row < 0 || col < 0 || row >= r || col >= c || isVisited[row][col] || alphabet[arr[row][col] - 'A']) {
			answer = Math.max(answer, count);
			return;
		}

		isVisited[row][col] = true;
		alphabet[arr[row][col] - 'A'] = true;
		for (int i = 0; i < 4; ++i) {
			int nx = col + dx[i];
			int ny = row + dy[i];
			dfs(ny, nx, count + 1);
		}
		isVisited[row][col] = false;
		alphabet[arr[row][col] - 'A'] = false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		isVisited = new boolean[r][c];

		for (int i = 0; i < r; ++i) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < c; ++j) {
				arr[i][j] = input[j];
			}
		}
		dfs(0, 0, 0);
		System.out.println(answer);
	}
}
