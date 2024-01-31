package baekjoon.implementation;

import java.util.*;
import java.io.*;

public class BJ5430 {
	private static String solution(String cmd, int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		boolean reversed = false;
		StringBuilder sb = new StringBuilder();

		for (char ch : cmd.toCharArray()) {
			if (ch == 'R') {
				reversed = !reversed;
			} else if (ch == 'D') {
				if (start > end) {
					return "error";
				}
				if (reversed) {
					--end;
				} else {
					++start;
				}
			}
		}
		sb.append("[");
		if (!reversed) {
			for (int i = start; i <= end; ++i) {
				sb.append(arr[i]);
				if (i != end)
					sb.append(",");
			}
		} else {
			for (int i = end; i >= start; --i) {
				sb.append(arr[i]);
				if (i != start)
					sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; ++i) {
			String cmd = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String[] split = str.substring(1, str.length() - 1).split(",");
			int[] arr;
			if (split.length == 1 && split[0].isEmpty()) {
				arr = new int[n];
			} else {
				arr = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
			}

			sb.append(solution(cmd, arr)).append("\n");
		}
		System.out.print(sb);
	}
}
