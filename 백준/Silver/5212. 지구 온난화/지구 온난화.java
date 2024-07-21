import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int R, C;
	private static char[][] arr;
	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};
	private static StringBuilder sb = new StringBuilder();

	private static boolean check(int row, int col) {
		int count = 0;

		for (int i = 0; i < 4; ++i) {
			int nextRow = row + dr[i];
			int nextCol = col + dc[i];
			if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C || arr[nextRow][nextCol] == '.')
				++count;
		}
		return count >= 3;
	}

	private static void solution() {
		List<Point> list = new ArrayList<>();

		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				if (arr[i][j] == 'X' && check(i, j)) {
					list.add(new Point(i, j));
				}
			}
		}

		// update map
		for (Point point : list) {
			arr[point.row][point.col] = '.';
		}

		// find map size
		int minRow = R - 1, minCol = C - 1, maxRow = 0, maxCol = 0;
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				if (arr[i][j] == 'X') {
					minRow = Math.min(minRow, i);
					maxRow = Math.max(maxRow, i);
					minCol = Math.min(minCol, j);
					maxCol = Math.max(maxCol, j);
				}
			}
		}

		// print
		for (int i = minRow; i <= maxRow; ++i) {
			for (int j = minCol; j <= maxCol; ++j) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];

		for (int i = 0; i < R; ++i) {
			String row = br.readLine();
			for (int j = 0; j < C; ++j) {
				arr[i][j] = row.charAt(j);
			}
		}

		solution();
	}

	private static class Point {
		int row, col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
