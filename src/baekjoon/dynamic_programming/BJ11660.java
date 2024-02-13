package baekjoon.dynamic_programming;

import java.io.*;
import java.util.*;

public class BJ11660 {
	private static int N, M;
	private static int[] arr;

	private static void cumulativeSum() {
		for (int i = 0; i < N; ++i) {
			for (int j = 1; j <= N; ++j) {
				int index = i * N + j;
				arr[index] += arr[index - 1];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N * N + 1];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; ++j) {
				arr[i * N + j] = Integer.parseInt(st.nextToken());
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
			for (int j = x1 - 1; j < x2; ++j) {
				result += (arr[j * N + y2] - arr[j * N + y1 - 1]);
			}

			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}
