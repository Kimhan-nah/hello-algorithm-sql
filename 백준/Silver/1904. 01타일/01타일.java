import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final int MOD = 15746;
	
	private static int solution(int n) {
		if (n == 1) {
			return 1;
		}
		int[] fibonacci = new int[n + 1];
		fibonacci[1] = 1;
		fibonacci[2] = 2;

		for (int i = 3; i <= n; ++i) {
			fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % MOD;
		}
		return fibonacci[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = solution(n);
		System.out.println(answer);
	}
}
