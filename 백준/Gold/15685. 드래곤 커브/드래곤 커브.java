import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	// RIGHT, UP, LEFT, DOWN
	private static int[] dr = {0, -1, 0, 1};
	private static int[] dc = {1, 0, -1, 0};
	private static boolean[][] arr = new boolean[101][101];

	private static void dragonCurve(int x, int y, int d, int g) {
		List<Integer> directions = new ArrayList<>();
		int row = y + dr[d];
		int col = x + dc[d];

		directions.add(d);
		arr[y][x] = true;
		arr[row][col] = true;

		for (int i = 0; i < g; ++i) {
			List<Integer> append = new ArrayList<>();
			for (int j = directions.size() - 1; j >= 0; --j) {
				int direction = (directions.get(j) + 1) % 4;
				row += dr[direction];
				col += dc[direction];
				append.add(direction);
				arr[row][col] = true;
			}
			directions.addAll(append);
		}
	}

	private static int countSquare() {
		int count = 0;

		for (int i = 0; i < arr.length - 1; ++i) {
			for (int j = 0; j < arr.length - 1; ++j) {
				if (arr[i][j] && arr[i + 1][j] && arr[i][j + 1] && arr[i + 1][j + 1]) {
					++count;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dragonCurve(x, y, d, g);
		}

		int count = countSquare();
		System.out.println(count);
	}
}
