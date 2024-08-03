import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[] arr;
	private static int[] dp;

	private static int solution() {
		int max = arr[0];
		dp[0] = arr[0];

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
			dp[i] = dp[i] == 0 ? arr[i] : dp[i];
			max = Math.max(max, dp[i]);
		}

		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = solution();
		System.out.println(answer);
	}
}
