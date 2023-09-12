package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class BJ2667 {
  static int[][] check;
  static char[][] arr;
  static int n;
  private static int DFS(int row, int col) {
    if (row < 0 || col < 0 || row == n || col == n || check[row][col] == 1 || arr[row][col] != '1') return 0;

    check[row][col] = 1;    //지나감

    return 1 + DFS(row, col + 1) + DFS(row + 1, col) + DFS(row - 1, col) + DFS(row, col - 1);
  }

  private static void solution() {
    int total = 0;
    ArrayList<Integer> answer = new ArrayList<>();

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        if (check[i][j] != 1 && arr[i][j] == '1') {
          ++total;
          int count = DFS(i, j);
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
