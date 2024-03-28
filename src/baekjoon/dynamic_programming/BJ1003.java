package baekjoon.dynamic_programming;

import java.io.*;

public class BJ1003 {
	private static int[] fibonacci(int n) {
		int[][] arr = new int[41][2];
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;

		for (int i = 2; i <= n; ++i) {
			arr[i][0] = arr[i - 2][0] + arr[ i - 1][0];
			arr[i][1] = arr[i - 2][1] + arr[ i - 1][1];
		}
		return arr[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; ++i) {
			int n = Integer.parseInt(br.readLine());
			int[] counts = fibonacci(n);
			sb.append(counts[0]).append(" ").append(counts[1]).append("\n");
		}
		System.out.print(sb);
	}
}
