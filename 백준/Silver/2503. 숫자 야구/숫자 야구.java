import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static boolean isPossible(int[][] info, String check) {
		// check 847

		for (int i = 0; i < info.length; ++i) {
			// 123 1 1
			String num = Integer.toString(info[i][0]);

			// strike
			int strike = 0;
			for (int j = 0; j < 3; ++j) {
				if (check.charAt(j) == num.charAt(j)) {
					++strike;
				}
			}
			if (strike != info[i][1]) {
				return false;
			}

			// ball
			int ball = 0;
			for (int j = 0; j < 3; ++j) {
				for (int k = 0; k < 3; ++k) {
					if (j == k)
						continue;
					if (check.charAt(j) == num.charAt(k)) {
						++ball;
					}
				}
			}
			if (ball != info[i][2]) {
				return false;
			}
		}

		return true;
	}

	private static int solution(int n, int[][] info) {
		int count = 0;

		for (int i = 1; i <= 9; ++i) {
			for (int j = 1; j <= 9; ++j) {
				if (i == j)
					continue;
				for (int k = 1; k <= 9; ++k) {
					if (i == k || j == k)
						continue;
					int answer = i * 100 + j * 10 + k;
					if (isPossible(info, Integer.toString(answer))) {
						++count;
					}
				}
			}
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] info = new int[n][3];

		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
			info[i][2] = Integer.parseInt(st.nextToken());
		}
		int answer = solution(n, info);
		System.out.println(answer);
	}
}
