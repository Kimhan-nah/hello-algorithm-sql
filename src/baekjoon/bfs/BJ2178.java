package baekjoon.bfs;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.io.*;

class Point {
  int row, col;

  public Point(int row, int col) {
    this.row = row;
    this.col = col;
  }
}

public class BJ2178 {
  static char[][] map;
  static int n, m;

  private static int solution() {
    int answer = 1;
    Queue<Point> queue = new LinkedList<>();
    int[] dy = {1, 0, -1, 0};
    int[] dx = {0, 1, 0, -1};

    queue.offer(new Point(1, 1));
    map[1][1] = '0';

    while (!queue.isEmpty()) {
      int len = queue.size();
      for (int i = 0; i < len; ++i) {
        Point current = queue.poll();
        int row = current.row;
        int col = current.col;
        if (row == n && col == m) return answer;

        for (int j = 0; j < 4; ++j) {
          int nextRow = row + dy[j];
          int nextCol = col + dx[j];
          if (nextRow < 1 || nextRow > n || nextCol < 1 || nextCol > m || map[nextRow][nextCol] == '0') continue;
          queue.offer(new Point(nextRow, nextCol));
          map[nextRow][nextCol] = '0';
        }
      }
      ++answer;
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new char[n + 1][m + 1];

    for (int i = 1; i <= n; ++i) {
      String str = br.readLine();
      char[] tmp = str.toCharArray();
      for (int j = 1; j <= m; ++j) {
        map[i][j] = tmp[j - 1];
      }
    }
    int answer = solution();
    System.out.println(answer);
  }
}
