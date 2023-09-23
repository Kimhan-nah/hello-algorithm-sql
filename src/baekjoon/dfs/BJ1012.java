package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class BJ1012 {
  private static StringBuilder sb = new StringBuilder();

  private static void DFS(boolean[][] map, int row, int col) {
    if (row == map.length || row < 0 || col == map[0].length || col < 0 || !map[row][col]) return ;

    map[row][col] = false;
    DFS(map, row, col + 1);
    DFS(map, row + 1, col);
    DFS(map, row, col - 1);
    DFS(map, row - 1, col);
  }

  private static void solution(boolean[][] map, int row, int col) {
    int count = 0;

    for (int i = 0; i < row; ++i) {
      for (int j = 0; j < col; ++j) {
        if (map[i][j]) {
          DFS(map, i, j);
          ++count;
        }
      }
    }

    sb.append(count + " ");
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken()); // 가로 (col)
      int n = Integer.parseInt(st.nextToken()); // 세로 (row)
      int k = Integer.parseInt(st.nextToken()); // 배추 갯수
      boolean[][] map = new boolean[n][m];
      for (int j = 0; j < k; ++j) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        map[y][x] = true;
      }
      solution(map, n, m);
    }
    System.out.println(sb);
  }
}
