package baekjoon.dynamic_programming;

import java.io.*;
import java.util.*;

public class BJ11660 {
	private static int N, M;
	private static int[][] arr;

	private static void cumulativeSum() {
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				arr[i][j] += arr[i][j - 1];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cumulativeSum();
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int result = 0;
			for (int j = x1; j <= x2; ++j) {
				result += (arr[j][y2] - arr[j][y1 - 1]);
			}

			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}
