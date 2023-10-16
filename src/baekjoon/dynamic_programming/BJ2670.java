package baekjoon.dynamic_programming;

import java.io.*;

public class BJ2670 {
  private static String solution(double[] arr) {
    double max = Double.MIN_VALUE;
    double[] dp = new double[arr.length];

    dp[0] = arr[0];
    for (int i = 1; i < arr.length; ++i) {
      dp[i] = Math.max(arr[i], dp[i - 1] * arr[i]);
      max = Math.max(max, dp[i]);
    }
    return String.format("%.3f", max);
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    double[] arr = new double[N];

    for (int i = 0; i < N; ++i) {
      arr[i] = Double.parseDouble(br.readLine());
    }
    String answer = solution(arr);
    System.out.println(answer);
  }
}
