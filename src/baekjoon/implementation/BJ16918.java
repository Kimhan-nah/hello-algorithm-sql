package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class BJ16918 {
	private static int r, c, n;
	private static int[][] arr;
	private static int[] dirRow = {-1, 1, 0, 0};
	private static int[] dirCol = {0, 0, -1, 1};

	private static void install() {
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				++arr[i][j];
			}
		}
	}

	private static void bomb() {
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (arr[i][j] == 2) {
					arr[i][j] = -1;

					// 상하좌우
					for (int k = 0; k < 4; ++k) {
						int nr = i + dirRow[k];
						int nc = j + dirCol[k];
						if (nr < 0 || nc < 0 || nr == r || nc == c || arr[nr][nc] == 2) continue;
						arr[nr][nc] = -1;
					}
				} else if (arr[i][j] != -1) {
					++arr[i][j];
				}
			}
		}
	}
	private static void solution() {
		for (int i = 1; i < n; ++i) {
			if (i % 2 == 1) {
				install();
			} else {
				bomb();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[r][c];

		for (int i = 0; i < r; ++i) {
			String row = br.readLine();
			for (int j = 0; j < c; ++j) {
				if (row.charAt(j) == '.') {
					arr[i][j] = -1;
				} else {
					arr[i][j] = 1;
				}
			}
		}
		solution();

		// print
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (arr[i][j] == -1) {
					sb.append('.');
				} else {
					sb.append('O');
				}
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
