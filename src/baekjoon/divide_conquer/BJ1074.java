package baekjoon.divide_conquer;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1074 {
	private static int n ,r, c;
	private static int answer = 0;

	private static void recursive(int row, int col, int length, int count) {
		if (row == r && col == c) {
			answer = count;
			return;
		}
		int dividedLength = length / 2;

		if (row + length / 2 > r) {
			if (col + length / 2 > c) {
				// 1 사분면
				recursive(row, col, dividedLength, count);
			} else {
				// 2 사분면
				int tmp = dividedLength * dividedLength;
				recursive(row, col + dividedLength, dividedLength, count + tmp);
			}
		} else {
			if (col + length / 2 > c) {
				// 3 사분면
				int tmp = dividedLength * dividedLength * 2;
				recursive(row + dividedLength, col, dividedLength, count + tmp);
			} else {
				// 4 사분면
				int tmp = dividedLength * dividedLength * 3;
				recursive(row + dividedLength, col + dividedLength, dividedLength, count + tmp);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = (int)Math.pow(2, n);

		recursive(0, 0, n, 0);

		System.out.println(answer);
	}
}
