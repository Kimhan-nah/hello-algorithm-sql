import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static long[] arr = new long[101];
	private static StringBuilder sb = new StringBuilder();

	private static long solution(int n) {
		if (arr[n] > 0) {
			return arr[n];
		}
		return arr[n] = solution(n - 1) + solution(n - 5);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 2;
		arr[4] = 2;

		for (int i = 0; i < T; ++i) {
			int n = Integer.parseInt(br.readLine());
			long answer = solution(n - 1);
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
}
