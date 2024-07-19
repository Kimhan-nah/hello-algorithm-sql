import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int n, find;
	private static int[][] arr;
	// 아래, 오른쪽, 위, 왼쪽
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	private static StringBuilder sb = new StringBuilder();

	private static void solution() {
		int row = 0, col = 0, dir = 0;
		int num = n * n;
		int findRow = 0, findCol = 0;

		while (num > 0) {
			arr[row][col] = num;
			if (num == find) {
				findRow = row;
				findCol = col;
			}
			--num;
			int nextRow = row + dy[dir];
			int nextCol = col + dx[dir];
			if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || arr[nextRow][nextCol] > 0) {
				dir = (dir + 1) % 4;
				nextRow = row + dy[dir];
				nextCol = col + dx[dir];
			}
			row = nextRow;
			col = nextCol;
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(findRow + 1).append(" ").append(findCol + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		find = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		solution();
		System.out.println(sb);
	}
}
