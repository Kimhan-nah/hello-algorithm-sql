import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];

		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		int answer = solution();
		System.out.println(answer);
	}

	private static int solution() {
		int[][] map = new int[100][100];

		for (int i = 0; i < n; ++i) {
			int x = arr[i][0];
			int y = arr[i][1];
			for (int row = y; row < y + 10; ++row) {
				for (int col = x; col < x + 10; ++col) {
					map[row][col] = 1;
				}
			}
		}
		return (int)Arrays.stream(map)
			.flatMapToInt(Arrays::stream)
			.filter(x -> x == 1)
			.count();
	}
}
