import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static long[] prefixSum;
	private static long[] modulo;
	
	private static long comb(long n) {
		if (n < 2)
			return 0;
		else
			return n * (n - 1) / 2;
	}

	private static long solution() {
		for (int i = 0; i < N; ++i) {
			++modulo[(int)(prefixSum[i] % M)];
		}

		long count = 0;
		for (int i = 0; i < M; ++i) {
			count += comb(modulo[i]);
		}

		return count + modulo[0];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		prefixSum = new long[N];
		modulo = new long[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			prefixSum[i] = Integer.parseInt(st.nextToken());
			if (i > 0)
				prefixSum[i] += prefixSum[i - 1];
		}
		long answer = solution();
		System.out.println(answer);
	}
}
