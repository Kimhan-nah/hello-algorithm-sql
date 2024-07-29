import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	private static void solution(String str, int left, int right, int count) {
		if (left >= right) {
			sb.append(1).append(" ").append(count).append("\n");
			return;
		}
		if (str.charAt(left) != str.charAt(right)) {
			sb.append(0).append(" ").append(count).append("\n");
			return;
		}
		solution(str, left + 1, right - 1, count + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; ++i) {
			String str = br.readLine();
			solution(str, 0, str.length() - 1, 1);
		}
		System.out.print(sb);
	}
}
