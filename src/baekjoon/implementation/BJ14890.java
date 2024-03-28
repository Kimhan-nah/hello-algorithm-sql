package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class BJ14890 {
	private static int N, L;
	private static int[][] arr;

	private static boolean isPossible(int row, int col, boolean flag) {
		int[] height = new int[N];
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; ++i) {
			if (flag) {
				height[i] = arr[row][i];
			} else {
				height[i] = arr[i][col];
			}
		}

		for (int i = 0; i < N - 1; ++i) {
			int diff = height[i] - height[i + 1];
			if (diff == 0) continue;
			if (diff == 1) {
				for (int j = i + 1; j <= i + L; ++j) {
					if (j >= N || height[i + 1] != height[j] || visited[j]) return false;
					visited[j] = true;
				}
			} else if (diff == -1) {
				for (int j = i; j > i - L; --j) {
					if (j < 0 || height[i] != height[j] || visited[j]) return false;
					visited[j] = true;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	private static int solution() {
		int answer = 0;

		for (int i = 0; i < N; ++i) {
			if (isPossible(i, 0, true)) {
				++answer;
			}
			if (isPossible(0, i, false)) {
				++answer;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N][N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int solution = solution();
		System.out.println(solution);
	}
}
