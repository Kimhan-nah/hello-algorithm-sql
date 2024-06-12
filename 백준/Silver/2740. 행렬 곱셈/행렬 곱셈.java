import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static int N, M, K;
	private static int[][] A;
	private static int[][] B;

	private static void solution() {
		int[][] answer = new int[N][K];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < K; ++j) {
				for (int k = 0; k < M; ++k) {
					answer[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		for (int[] row : answer) {
			for (int col : row) {
				sb.append(col).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		B = new int[M][K];
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; ++j) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solution();
	}
}
