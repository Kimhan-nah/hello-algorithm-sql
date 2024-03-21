package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class BJ2607 {
	private static void solution(int n, String[] inputs) {
		int answer = n - 1;
		String pivot = inputs[0];
		int[] alphabets = new int[26];

		for (int i = 0; i < pivot.length(); ++i) {
			alphabets[pivot.charAt(i) - 'A']++;
		}

		for (int i = 0; i < n; ++i) {
			String str = inputs[i];
			if (Math.abs(str.length() - pivot.length()) > 1) {
				--answer;
				continue;
			}
			int[] arr = new int[26];
			for (char ch : str.toCharArray()) {
				arr[ch - 'A']++;
			}

			//compare
			int diff = 0;
			for (int j = 0; j < 26; ++j) {
				if (alphabets[j] != arr[j]) {
					diff += Math.abs(alphabets[j] - arr[j]);
				}
			}
			if (diff > 2 || (diff == 2 && pivot.length() != str.length())) {
				--answer;
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] inputs = new String[n];

		for (int i = 0; i < n; ++i) {
			inputs[i] = br.readLine();
		}
		solution(n, inputs);
	}
}
