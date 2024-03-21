package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class BJ2564 {
	private static int width, height, n;
	private static int[] arr;
	private static int pivot;

	private static int solution() {
		int answer = 0;
		int total = width * 2 + height * 2;
		for (int point : arr) {
			int smaller = Math.min(point, pivot);
			int bigger = Math.max(point, pivot);
			int diff = Math.min(bigger - smaller, total - bigger + smaller);
			answer += diff;
		}
		return answer;
	}

	private static int calculateDistance(int dir, int distance) {
		if (dir == 1) {
			return distance;
		} else if (dir == 2) {
			return width + height + width - distance;
		} else if (dir == 3) {
			return width * 2 + height + height - distance;
		} else {
			return width + distance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		for (int i = 0; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			if (i == n) {
				pivot = calculateDistance(dir, distance);
			} else {
				arr[i] = calculateDistance(dir, distance);
			}
		}

		int answer = solution();
		System.out.println(answer);
	}
}
