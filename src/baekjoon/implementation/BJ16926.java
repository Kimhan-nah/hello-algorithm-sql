package baekjoon.implementation;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ16926 {
	private static int N, M, R;
	private static int[][] arr;

	private static void solution() {
		int min = Math.min(N, M);
		int mid = min / 2;

		for (int i = 0; i < mid; ++i) {
			int tmp = arr[i][i]; // start point

			for (int j = i; j < M - 1 - i; ++j) {
				// 위 행 : 왼쪽으로
				arr[i][j] = arr[i][j + 1];
			}
			for (int j = i + 1; j < N - i; ++j) {
				// 오른쪽 열 : 위로
				arr[j - 1][M - 1 - i] = arr[j][M - 1 - i];
			}
			for (int j = M - 1 - i; j > i; --j) {
				// 아래 행 : 오른쪽으로
				arr[N - 1 - i][j] = arr[N - 1 - i][j - 1];
			}
			for (int j = N - 1 - i; j > i; --j) {
				// 왼쪽 열 : 아래로
				arr[j][i] = arr[j - 1][i];
			}
			arr[i + 1][i] = tmp;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < R; ++i) {
			solution();
		}

		StringBuilder sb = new StringBuilder();
		for (int[] row : arr) {
			for (int col : row) {
				sb.append(col).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
