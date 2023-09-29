package baekjoon.bfs;

import java.util.*;
import java.io.*;


public class BJ2468 {
  static int[][] arr;
  static int n, min, max;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static class Point {
    int row, col;

    public Point(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  private static int bfs(boolean[][] visited, int row, int col) {
    Queue<Point> queue = new LinkedList<>();
    int count = 0;

    queue.offer(new Point(row, col));
    visited[row][col] = true;
    while (!queue.isEmpty()) {
      int len = queue.size();
      for (int i = 0; i < len; ++i) {
        Point current = queue.poll();
        int currentRow = current.row;
        int currentCol = current.col;
        for (int j = 0; j < 4; ++j) {
          int nextRow = currentRow + dy[j];
          int nextCol = currentCol + dx[j];
          if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || arr[nextRow][nextCol] == 0 || visited[nextRow][nextCol]) continue;
          queue.offer(new Point(nextRow, nextCol));
          visited[nextRow][nextCol] = true;
        }
      }
      ++count;
    }
    return count;
  }

  private static int solution() {
    int answer = 1;

    for (int i = min; i <= max; ++i) {
      // 물 잠긴 지역 0으로 바꾸기
      for (int j = 0; j < n; ++j) {
        for (int k = 0; k < n; ++k) {
          if (arr[j][k] == i) {
            arr[j][k] = 0;  // visit
          }
        }
      }

      // 분리된 것 확인
      int count = 0;
      boolean[][] visited = new boolean[n][n];
      for (int j = 0; j < n; ++j) {
        for (int k = 0; k < n; ++k) {
          if (arr[j][k] != 0 && !visited[j][k]) {
            bfs(visited, j, k);
            ++count;
          }
        }
      }

      answer = Math.max(answer, count);
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    min = Integer.MAX_VALUE;
    max = Integer.MIN_VALUE;

    for (int i = 0; i < n; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; ++j) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        min = Math.min(min, arr[i][j]);
        max = Math.max(max, arr[i][j]);

      }
    }
    int answer = solution();
    System.out.println(answer);
  }
}
