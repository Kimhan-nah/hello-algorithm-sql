package baekjoon.implementation;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1138 {
	private static int n;
	private static int[] arr;
	private static int[] answer;

	private static void solution() {

		for (int i = 0; i < n; ++i) {
			int count = arr[i];
			int index = 0;
			while (count > 0 || answer[index] != 0) {
				if (answer[index] == 0) {
					--count;
				}
				index = (index + 1) % n;
			}
			answer[index] = i + 1;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		answer = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		solution();

		StringBuilder sb = new StringBuilder();
		for (int ele : answer) {
			sb.append(ele).append(" ");
		}
		System.out.println(sb);

	}
}
