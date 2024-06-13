import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int[][] arr;
	private static int[] answers = new int[3];

	private static boolean check(int row, int col, int size) {
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				if (arr[row][col] != arr[row + i][col + j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void solution(int row, int col, int size) {
		if (check(row, col, size)) {
			++answers[arr[row][col] + 1];
			return;
		}
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				solution(row + i * size / 3, col + j * size / 3, size / 3);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solution(0, 0, N);
		for (int answer : answers) {
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
}
