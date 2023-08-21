package inflearn.section_8;

import java.util.*;

public class Sequence {
  static int[][] dy = new int[35][35];
  private static int[] arr, answer, check;
  private static int n, f;
  private static boolean flag = false;

  private static void solution(int level, int sum) {
    if (flag) return ;
    if (level == n) {
      if (sum == f) {
        for (int x : answer) System.out.print(x + " ");
        System.out.println();
        flag = true;
      }
      return ;
    }

    for (int i = 0; i < n; ++i) {   // permutation
      if (check[i] == 0) {
        check[i] = 1;
        answer[level] = i + 1;
        solution(level + 1, sum + arr[level] * answer[level]);
        check[i] = 0;
      }
    }
  }

  private static int combination(int n, int r) {
    if (dy[n][r] > 0) return dy[n][r];
    if (r == 1) return n;
    if (r == 0 || r == n) return 1;
    return dy[n][r] = combination(n-1, r-1) + combination(n-1, r);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    f = sc.nextInt();
    arr = new int[n];
    answer = new int[n];
    check = new int[n];
    for (int i = 0; i < n; ++i) {
      arr[i] = combination(n - 1, i);
    }
    int[] buf = new int[n];

    solution(0, 0);
  }
}
