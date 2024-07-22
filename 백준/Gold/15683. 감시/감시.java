import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};
	private static boolean[][][] dir = {
		// RIGHT, DOWN, LEFT, UP
		// 1
		{
			{true, false, false, false},
			{false, true, false, false},
			{false, false, true, false},
			{false, false, false, true}
		},
		// 2
		{
			{true, false, true, false},
			{false, true, false, true}
		},
		// 3
		{
			{true, false, false, true},
			{true, true, false, false},
			{false, true, true, false},
			{false, false, true, true}
		},
		// 4
		{
			{true, false, true, true},
			{true, true, false, true},
			{true, true, true, false},
			{false, true, true, true}
		},
		// 5
		{
			{true, true, true, true}
		}
	};
	private static int N, M;
	private static List<Point> locations;
	private static int min = Integer.MAX_VALUE;

	private static void update(int[][] arr, int dir, int row, int col) {
		int nextRow = row;
		int nextCol = col;

		while (true) {
			nextRow += dr[dir];
			nextCol += dc[dir];
			if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M || arr[nextRow][nextCol] == 6)
				return;
			if (arr[nextRow][nextCol] > 0)
				continue;
			arr[nextRow][nextCol] = -1;
		}

	}

	private static void solution(int cctvIndex, int[][] arr) {
		if (cctvIndex == locations.size() || min == 0) {
			min = Math.min(min,
				(int)Arrays.stream(arr).flatMapToInt(Arrays::stream).filter(value -> value == 0).count());
			return;
		}
		Point location = locations.get(cctvIndex);
		int cctv = arr[location.row][location.col];

		for (boolean[] directions : dir[cctv - 1]) {
			int[][] copy = Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new);
			for (int j = 0; j < directions.length; ++j) {
				if (!directions[j])
					continue;
				update(copy, j, location.row, location.col);
			}
			solution(cctvIndex + 1, copy);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		locations = new ArrayList<>();

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0 && arr[i][j] != 6) {
					locations.add(new Point(i, j));
				}
			}
		}
		solution(0, arr);
		System.out.println(min);
	}

	private static class Point {
		int row, col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

}
