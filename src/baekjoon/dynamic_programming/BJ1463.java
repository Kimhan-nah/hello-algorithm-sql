package baekjoon.dynamic_programming;

import java.io.*;

public class BJ1463 {
  static int answer = Integer.MAX_VALUE;

  private static void solution(int N, int level) {
    if (N == 1) {
      answer = Math.min(answer, level);
      return ;
    }

    if (N % 3 == 0) solution(N / 3, level + 1);
    if (N % 2 == 0) solution(N / 2, level + 1);
    solution(N - 1, level + 1);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    solution(N, 0);
    System.out.println(answer);
  }
}
