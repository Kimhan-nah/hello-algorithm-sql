package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class BJ14888 {
	private static int n;
	private static int[] sequence;
	private static char[] operations;
	private static boolean[] isUsed;
	private static int min = Integer.MAX_VALUE;
	private static int max = Integer.MIN_VALUE;

	private static void solution(int calculated, int level) {
		if (level == n) {
			min = Math.min(min, calculated);
			max = Math.max(max, calculated);
			return;
		}

		for (int i = 0; i < n - 1; ++i) {
			if (isUsed[i]) {
				continue;
			}
			isUsed[i] = true;
			int nextCalculated = calculated;
			int operand = sequence[level];
			switch (operations[i]) {
				case '+':
					nextCalculated += operand;
					break;
				case '-':
					nextCalculated -= operand;
					break;
				case '*':
					nextCalculated *= operand;
					break;
				case '/':
					nextCalculated /= operand;
					break;
			}
			solution(nextCalculated, level + 1);
			isUsed[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sequence = new int[n];
		operations = new char[n - 1];
		isUsed = new boolean[n - 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int multi = Integer.parseInt(st.nextToken());
		int division = Integer.parseInt(st.nextToken());

		Arrays.fill(operations, 0, plus, '+');
		Arrays.fill(operations, plus, plus + minus, '-');
		Arrays.fill(operations, plus + minus, plus + minus + multi, '*');
		Arrays.fill(operations, plus + minus + multi, plus + minus + multi + division, '/');

		solution(sequence[0], 1);

		System.out.println(max);
		System.out.println(min);

	}
}
