package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class BJ15686 {
	private static int n, m;
	private static List<Point> chickens = new ArrayList<>();
	private static List<Point> homes = new ArrayList<>();
	private static boolean[] isSelected;
	private static int answer = Integer.MAX_VALUE;

	private static void combi(int level) {
		if (level == m) {
			// 도시 치킨 거리 구하기 (모든 집에서의 치킨 거리 합 구하기)
			int sum = 0;
			for (int i = 0; i < homes.size(); ++i) {
				int distance = Integer.MAX_VALUE;
				Point home = homes.get(i);
				for (int j = 0; j < isSelected.length; ++j) {
					if (!isSelected[j]) continue;
					Point chicken = chickens.get(j);
					int d = Math.abs(chicken.row - home.row) + Math.abs(chicken.col - home.col);
					distance = Math.min(distance, d);
				}
				sum += distance;
			}
			answer = Math.min(answer, sum);

			return;
		}

		for (int i = 0; i < chickens.size(); ++i) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			combi(level + 1);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					homes.add(new Point(i, j));
				} else if (num == 2) {
					chickens.add(new Point(i, j));
				}
			}
		}
		isSelected = new boolean[chickens.size()];

		combi(0);
		System.out.println(answer);
	}

	static class Point {
		int row, col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
