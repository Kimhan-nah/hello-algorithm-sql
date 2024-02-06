package baekjoon.graph;

import java.io.*;
import java.util.*;

public class BJ11403 {
	private static int n;
	private static List<Integer>[] graph;
	private static int[][] answer;

	private static void solution(int from, int to) {
		if (answer[from][to] > 1) {
			return;
		}
		++answer[from][to];
		for (int i : graph[to]) {
			solution(from, i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 n = Integer.parseInt(br.readLine());
		graph = new List[n];
		answer = new int[n][n];

		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			graph[i] = new ArrayList<>();
			for (int j = 0; j < n; ++j) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					graph[i].add(j);
					answer[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < n; ++i) {
			for (int j : graph[i]) {
				solution(i, j);
			}
		}

		// print
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (answer[i][j] > 0) {
					sb.append(1);
				} else {
					sb.append(0);
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
