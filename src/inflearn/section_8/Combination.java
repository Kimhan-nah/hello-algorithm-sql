package inflearn.section_8;

import java.util.*;

public class Combination {
  static int[][] dy = new int[35][35];

  private static int solution(int n, int r) {
    if (dy[n][r] > 0) return dy[n][r];
    if (r == 1) return n;
    if (r == 0 || r == n) return 1;
    return dy[n][r] = solution(n-1, r-1) + solution(n-1, r);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int answer = solution(n, m);
    System.out.println(answer);
  }
}
