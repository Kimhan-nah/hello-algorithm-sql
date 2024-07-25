import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, K;
	private static char[][] board;

	private static int solution() {
		int[][] prefixSum1 = new int[N][M];
		int[][] prefixSum2 = new int[N][M];

		// prefix sum
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (i % 2 == j % 2 && board[i][j] != 'B' || i % 2 != j % 2 && board[i][j] != 'W') {
					prefixSum1[i][j] = 1;
				} else {
					prefixSum2[i][j] = 1;
				}

				if (i > 0) {
					prefixSum1[i][j] += prefixSum1[i - 1][j];
					prefixSum2[i][j] += prefixSum2[i - 1][j];
				}
				if (j > 0) {
					prefixSum1[i][j] += prefixSum1[i][j - 1];
					prefixSum2[i][j] += prefixSum2[i][j - 1];
				}
				if (i > 0 && j > 0) {
					prefixSum1[i][j] -= prefixSum1[i - 1][j - 1];
					prefixSum2[i][j] -= prefixSum2[i - 1][j - 1];
				}
			}
		}

		return findMinPrefixSum(prefixSum1, prefixSum2);
	}

	private static int findMinPrefixSum(int[][] prefixSum1, int[][] prefixSum2) {
		int min = Integer.MAX_VALUE;
		for (int i = K - 1; i < N; ++i) {
			for (int j = K - 1; j < M; ++j) {
				int sum1 = prefixSum1[i][j];
				int sum2 = prefixSum2[i][j];

				if (i >= K) {
					sum1 -= prefixSum1[i - K][j];
					sum2 -= prefixSum2[i - K][j];
				}
				if (j >= K) {
					sum1 -= prefixSum1[i][j - K];
					sum2 -= prefixSum2[i][j - K];
				}
				if (i >= K && j >= K) {
					sum1 += prefixSum1[i - K][j - K];
					sum2 += prefixSum2[i - K][j - K];
				}
				min = Math.min(min, Math.min(sum1, sum2));
			}
		}
		return min;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new char[N][M];

		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			for (int j = 0; j < M; ++j) {
				board[i][j] = str.charAt(j);
			}
		}
		int answer = solution();
		System.out.println(answer);
	}
}
