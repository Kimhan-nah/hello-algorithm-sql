import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int N;
	private static boolean[] isPrime;

	private static void initPrime() {
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i <= N; ++i) {
			if (!isPrime[i]) {
				continue;
			}
			for (int j = 2; i * j <= N; ++j) {
				isPrime[i * j] = false;
			}
		}
	}

	private static int findNextPrime(int index) {
		for (int i = index + 1; i <= N; ++i) {
			if (isPrime[i]) {
				return i;
			}
		}
		return N + 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isPrime = new boolean[N + 1];
		int count = 0;
		int left = 2, right = 2, sum = right;
		initPrime();
		while (right <= N && left <= right) {
			if (sum < N) {
				right = findNextPrime(right);
				sum += right;
			} else if (sum > N) {
				sum -= left;
				left = findNextPrime(left);
			} else {
				++count;
				right = findNextPrime(right);
				sum += right;
			}
		}
		System.out.println(count);
	}
}
