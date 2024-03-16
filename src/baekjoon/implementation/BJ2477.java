package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class BJ2477 {
	private static int k;
	private static int[][] arr = new int[12][2];
	private static int width = Integer.MIN_VALUE;
	private static int height = Integer.MIN_VALUE;

	private static int solution() {
		int result = width * height;

		for (int i = 3; i < 12; ++i) {
			if (arr[i][0] == arr[i - 2][0] && arr[i - 1][0] == arr[i - 3][0]) {
				result -= (arr[i - 1][1] * arr[i - 2][1]);
				break;
			}
		}

		return result * k;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());

		for (int i = 0; i < 6; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			if (dir < 3) { // right, left
				height = Math.max(height, distance);
			} else { // down, up
				width = Math.max(width, distance);
			}
			arr[i][0] = dir;
			arr[i][1] = distance;
			arr[i + 6][0] = dir;
			arr[i + 6][1] = distance;
		}

		int answer = solution();

		System.out.println(answer);
	}

}
