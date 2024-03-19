package baekjoon.implementation;

import java.io.*;

public class BJ1213 {
	private static String str;
	private static int[] alphabets = new int[26];
	private static char[] answer;

	private static void solution() {
		int count = 0;
		for (int alphabet : alphabets) {
			if (alphabet % 2 == 1) {
				if (count > 0) {
					System.out.println("I'm Sorry Hansoo");
					return;
				}
				++count;
			}
		}

		int length = str.length();
		int index = 0;

		for (int i = 0; i < 26; ++i) {
			while (alphabets[i] > 1) {
				alphabets[i] -= 2;
				answer[index] = (char)(i + 'A');
				answer[length - index - 1] = (char)(i + 'A');
				++index;
			}
			if (alphabets[i] == 1) {
				answer[length / 2] = (char)(i + 'A');
			}
		}
		for (char ch : answer) {
			System.out.print(ch);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		answer = new char[str.length()];

		for (char ch : str.toCharArray()) {
			++alphabets[ch - 'A'];
		}

		solution();
	}
}
