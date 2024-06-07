import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] arr = new int[9][9];
	private static int count;
	private static boolean isFinished = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 9; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					++count;
				}
			}
		}
		if (count > 0) {
			Point point = findNextPoint(0, 0);
			solution(point.row, point.col);
		}

		// print arr
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void solution(int row, int col) {
		--count;
		for (int i = 1; i <= 9; ++i) {
			if (!checkLine(row, col, i)) {
				continue;
			}
			arr[row][col] = i;
			if (count == 0) {
				isFinished = true;
				return;
			}
			Point point = findNextPoint(row, col);
			solution(point.row, point.col);
			if (isFinished)
				return;
			arr[row][col] = 0;
		}
		++count;
	}

	private static boolean checkLine(int row, int col, int num) {
		// row, col
		for (int i = 0; i < 9; ++i) {
			if (arr[i][col] == num || arr[row][i] == num) {
				return false;
			}
		}

		// 3*3
		int squareRow = (row / 3) * 3;
		int squareCol = (col / 3) * 3;
		for (int i = squareRow; i < squareRow + 3; ++i) {
			for (int j = squareCol; j < squareCol + 3; ++j) {
				if (arr[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}

	private static Point findNextPoint(int row, int col) {
		int nextRow = 0, nextCol = 0;
		for (int i = row; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				if (arr[i][j] == 0) {
					nextRow = i;
					nextCol = j;
					return new Point(nextRow, nextCol);
				}
			}
		}
		return null;
	}

	private static class Point {
		int row, col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
