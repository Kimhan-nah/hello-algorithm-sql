package baekjoon.implementation.two_pointer;

import java.io.*;
import java.util.*;

public class BJ1806 {
	private static int N, S;
	private static int[] arr;

	private static int solution() {
		int answer  = Integer.MAX_VALUE;
		int left = 0, right = 0;
		int sum = 0;

		while (right < N) {
			if (sum >= S) {
				answer = Math.min(answer, right - left);
				sum -= arr[left];
				++left;
			} else {
				sum += arr[right];
				++right;
			}
		}

		while (sum >= S) {
			answer = Math.min(answer, right - left);
			sum -= arr[left];
			++left;
		}
		if (answer == Integer.MAX_VALUE) {
			return 0;
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = solution();
		System.out.println(answer);
	}
}
