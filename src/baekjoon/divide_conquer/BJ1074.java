package baekjoon.divide_conquer;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1074 {
	private static int n ,r, c;
	private static int count = -1;
	private static int[] dx = {0, 1, 0, 1};	// col
	private static int[] dy = {0, 0, 1, 1}; // row
	private static boolean isFinished;

	private static void recursive(int row, int col, int length) {
		if (isFinished) return;
		if (length == 1) {
			if (row == r && col == c) {
				isFinished = true;
			}
			++count;
			return;
		}

		int nextLength = length / 2;
		for (int i = 0; i < 4; ++i) {
			if (isFinished) return ;
			recursive(row + dy[i] * nextLength, col + dx[i] * nextLength, nextLength);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = (int)Math.pow(2, n);

		recursive(0, 0, n);

		System.out.println(count);
	}
}
