package baekjoon.brute_force;

import java.io.*;
import java.util.*;

public class BJ1107 {
	private static int answer;
	private static int N, M;
	private static boolean[] broken;

	private static void solution() {
		for (int i = 0; i <= 999999; ++i) {
			String str = Integer.toString(i);
			int length = str.length();
			boolean isBroken = false;
			for (int j = 0; j < length; ++j) {
				int check = str.charAt(j) - '0';
				if (broken[check]) {
					isBroken = true;
					break ;
				}
			}
			if (!isBroken) {
				answer = Math.min(answer, Math.abs(N - i) + length);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		broken = new boolean[10];
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; ++i) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		answer = Math.abs(N - 100);
		solution();
		System.out.println(answer);
	}
}
