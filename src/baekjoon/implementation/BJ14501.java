package baekjoon.implementation;

import java.io.*;
import java.util.StringTokenizer;

public class BJ14501 {
	private static int n;
	private static int[][] arr;
	private static int answer = Integer.MIN_VALUE;

	private static void solution(int date, int total) {
		if (date > n) {
			answer = Math.max(answer, total);
			return;
		}

		if (date + arr[date][0] - 1 <= n) {
			solution(date + arr[date][0], total + arr[date][1]);
		}
		if (arr[date][0] > 1) {
			solution(date + 1, total);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][2];

		for (int i = 1; i <= n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		solution(1, 0);
		System.out.println(answer);
	}
}
