package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class BJ2667 {
  static int[][] check;
  static char[][] arr;
  static int n;
  private static int DFS(int row, int col, int count) {
    if (row < 0 || col < 0 || row == n || col == n || check[row][col] == 1 || arr[row][col] != '1') return count;

    check[row][col] = 1;    //지나감
    ++count;

    count = DFS(row, col + 1, count);
    count = DFS(row + 1, col, count);
    count = DFS(row - 1, col, count);
    count = DFS(row, col - 1, count);

    return count;
  }

  private static void solution() {
    int total = 0;
    ArrayList<Integer> answer = new ArrayList<>();

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        if (check[i][j] != 1 && arr[i][j] == '1') {
          ++total;
          int count = DFS(i, j, 0);
          answer.add(count);
        }
      }
    }
    System.out.println(total);
    Collections.sort(answer);
    for (int x : answer) {
      System.out.println(x);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new char[n][n];
    check = new int[n][n];
    for (int i = 0; i < n; ++i) {
      String row = br.readLine();
      for (int j = 0; j < n; ++j) {
        arr[i][j] = row.charAt(j);
      }
    }
    solution();
  }
}
