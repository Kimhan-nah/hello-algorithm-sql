package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class BJ1080 {
  private static void operate(int[][] current, int row, int col) {
    for (int i = row; i < row + 3; ++i) {
      for (int j = col; j < col + 3; ++j) {
        current[i][j] = (current[i][j] + 1) % 2;  // 0->1, 1->0
      }
    }
  }

  private static int solution(int[][] procession, int n, int m) {
    int answer = 0;
    int[][] current = new int[n][m];

    if (Arrays.deepEquals(current, procession)) return 0;

    for (int i = 0; i < n - 2; ++i) {
      for (int j = 0; j < m - 2; ++j) {
        if (current[i][j] != procession[i][j]) {
          operate(current, i, j);
          ++answer;
          if (Arrays.deepEquals(current, procession)) return answer;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    char[][] a = new char[n][m];
    int[][] procession = new int[n][m];

    // parsing A
    for (int i = 0; i < n; ++i) {
      String tmp = br.readLine();
      for (int j = 0; j < m; ++j) {
        a[i][j] = tmp.charAt(j);
      }
    }

    // create procession
    for (int i = 0; i < n; ++i) {
      String tmp = br.readLine();
      for (int j = 0; j < m; ++j) {
        if (tmp.charAt(j) != a[i][j]) {
          procession[i][j] = 1;
        }
      }
    }

    int answer = solution(procession, n, m);
    System.out.println(answer);
  }
}
