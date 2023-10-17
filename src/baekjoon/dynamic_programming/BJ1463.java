package baekjoon.dynamic_programming;

import java.io.*;
import java.util.Arrays;

public class BJ1463 {
  static int answer = Integer.MAX_VALUE;
  static int[] dp;

  private static void solution(int N, int level) {
    if (N == 1) {
      answer = Math.min(answer, level);
      return ;
    }
    if (dp[N] < level) return ;

    dp[N] = level;

    if (N % 3 == 0) solution(N / 3, dp[N] + 1);
    if (N % 2 == 0) solution(N / 2, dp[N] + 1);
    solution(N - 1, dp[N] + 1);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    dp = new int[N + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    solution(N, 0);
    System.out.println(answer);
  }
}
