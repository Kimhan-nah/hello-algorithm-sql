package baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class BJ1918 {
	private static final Map<Character, Integer> operations = new HashMap<>();

	private static void solution(String expression) {
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (char ch : expression.toCharArray()) {
			if (Character.isAlphabetic(ch)) {
				sb.append(ch);
				continue;
			}
			if (ch == '(') {
				stack.push(ch);
				continue;
			}
			if (ch == ')') {
				while (stack.peek() != '(') {
					Character pop = stack.pop();
					sb.append(pop);
				}
				stack.pop();
				continue;
			}

			// compare priority
			while (!stack.isEmpty()) {
				Character peek = stack.peek();
				if (peek == '(' || operations.get(peek) > operations.get(ch)) {
					break;
				}
				sb.append(peek);
				stack.pop();
			}
			stack.push(ch);
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		operations.put('(', 0);
		operations.put(')', 0);
		operations.put('*', 1);
		operations.put('/', 1);
		operations.put('+', 2);
		operations.put('-', 2);
		solution(input);
	}
}
