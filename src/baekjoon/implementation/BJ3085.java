package baekjoon.implementation;

import java.io.*;

public class BJ3085 {
	private static int n;
	private static char[][] arr;
	private static int answer = Integer.MIN_VALUE;
	private static int[] dx = {0, 1};
	private static int[] dy = {1, 0};

	private static void checkLength(int row, int col, int dir) {
		int nx = col;
		int ny = row;
		int length = 0;
		int ch = arr[row][col];

		while (nx < n && ny < n) {
			if (ch == arr[ny][nx]) {
				++length;
			} else {
				answer = Math.max(answer, length);
				ch = arr[ny][nx];
				length = 1;
			}
			nx += dx[dir];
			ny += dy[dir];
		}
		answer = Math.max(answer, length);
	}

	private static void check(int x, int y, int nx, int ny) {
		// row -> right
		checkLength(y, 0, 1);
		if (y != ny) {
			checkLength(ny, 0, 1);
		}

		// col -> down
		checkLength(0, x, 0);
		if (x != nx) {
			checkLength(0, nx, 0);
		}
	}

	private static void solution() {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				for (int k = 0; k < 2; ++k) {
					int nx = j + dx[k];
					int ny = i + dy[k];
					if (ny == n || nx == n || arr[i][j] == arr[ny][nx]) continue;

					char tmp = arr[i][j];
					arr[i][j] = arr[ny][nx];
					arr[ny][nx] = tmp;
					check(j, i, nx, ny);
					tmp = arr[i][j];
					arr[i][j] = arr[ny][nx];
					arr[ny][nx] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];

		for (int i = 0; i < n; ++i) {
			String row = br.readLine();
			for (int j = 0; j < n; ++j) {
				arr[i][j] = row.charAt(j);
			}
			checkLength(i, 0, 1);
		}

		for (int i = 0; i < n; ++i) {
			checkLength(0, i, 0);
		}

		solution();
		System.out.println(answer);
	}
}
