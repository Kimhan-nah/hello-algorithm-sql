import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][][] dp = new int[21][21][21];
	private static StringBuilder sb = new StringBuilder();

	private static int recursive(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		if (a > 20 || b > 20 || c > 20) {
			return recursive(20, 20, 20);
		}
		if (dp[a][b][c] > 0) {
			return dp[a][b][c];
		}
		if (a < b && b < c) {
			dp[a][b][c] = recursive(a, b, c - 1) + recursive(a, b - 1, c - 1) - recursive(a, b - 1, c);
		} else {
			dp[a][b][c] = recursive(a - 1, b, c) + recursive(a - 1, b - 1, c) + recursive(a - 1, b, c - 1)
				- recursive(a - 1, b - 1, c - 1);
		}
		return dp[a][b][c];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1 && c == -1)
				break;
			int recursive = recursive(a, b, c);
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ")
				.append(recursive).append("\n");
		}

		System.out.print(sb);
	}
}
