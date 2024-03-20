package baekjoon.implementation;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1051 {
	private static int N, M;
	private static int[][] arr;
	private static int answer = Integer.MIN_VALUE;

	private static void solution() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				int vertex = arr[i][j];
				int length = 0;
				while (i + length < N && j + length < M) {
					if (vertex == arr[i + length][j] && vertex == arr[i][j + length] && vertex == arr[i + length][j
						+ length]) {
						answer = Math.max(answer, (length + 1)* (length + 1));
					}
					++length;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			for (int j = 0; j < M; ++j) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		solution();

		System.out.println(answer);
	}
}
