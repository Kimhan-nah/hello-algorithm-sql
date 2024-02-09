package baekjoon.graph;

import java.util.*;
import java.io.*;

public class BJ9019 {
	private static final int mod = 10000;
	private static int dslr(int a, char ch) {
		int res = a;

		switch (ch) {
			case 'D':
				res = (2 * res) % mod;
				break;
			case 'S':
				res = res == 0 ? 9999 : res - 1;
				break;
			case 'L':
				res = (res % 1000) * 10 + res / 1000;
				break;
			case 'R':
				res = (res % 10) * 1000 + res / 10;
				break;
		}
		return res;
	}

	private static String solution(int a, int b) {
		String[] dp = new String[10000];
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(a);
		dp[a] = "";

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				int poll = queue.poll();

				// DSLR
				for (char ch : "DSLR".toCharArray()) {
					int dslr = dslr(poll, ch);
					if (dp[dslr] != null) continue;
					queue.offer(dslr);
					dp[dslr] = dp[poll] + ch;
					if (dslr == b) {
						return dp[dslr];
					}
				}
			}
		}
		return "";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(solution(a, b)).append("\n");
		}
		System.out.print(sb);
	}
}
