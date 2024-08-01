import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int n;
	private static int[] arr;
	private static long[] dp;

	private static long solution() {
		if (n < 3)
			return n == 1 ? arr[0] : arr[0] + arr[1];

		dp[0] = arr[0];
		dp[1] = arr[0] + arr[1];
		dp[2] = Math.max(arr[0], arr[1]) + arr[2];

		for (int i = 3; i < n; ++i) {
			dp[i] = Math.max(dp[i - 2], arr[i - 1] + dp[i - 3]) + arr[i];
		}
		return dp[n - 1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new long[n];

		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		long answer = solution();
		System.out.println(answer);
	}
}
