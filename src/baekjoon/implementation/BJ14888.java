package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class BJ14888 {
	private static int n;
	private static int[] sequence;
	private static int[] operations;
	private static int min = Integer.MAX_VALUE;
	private static int max = Integer.MIN_VALUE;

	private static void solution(int calculated, int level) {
		if (level == n) {
			min = Math.min(min, calculated);
			max = Math.max(max, calculated);
			return;
		}

		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < operations[i]; ++j) {
				if (operations[i] < 1) continue;
				--operations[i];
				int nextCalculated = calculated;
				int operand = sequence[level];
				switch (i) {
					case 0:
						nextCalculated += operand;
						break;
					case 1:
						nextCalculated -= operand;
						break;
					case 2:
						nextCalculated *= operand;
						break;
					case 3:
						nextCalculated /= operand;
						break;
				}
				solution(nextCalculated, level + 1);
				++operations[i];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sequence = new int[n];
		operations = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		operations[0] = Integer.parseInt(st.nextToken());
		operations[1] =Integer.parseInt(st.nextToken());
		operations[2] = Integer.parseInt(st.nextToken());
		operations[3] =Integer.parseInt(st.nextToken());

		solution(sequence[0], 1);

		System.out.println(max);
		System.out.println(min);

	}
}
