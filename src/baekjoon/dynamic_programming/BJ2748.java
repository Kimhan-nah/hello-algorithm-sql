package baekjoon.dynamic_programming;

import java.io.*;
import java.util.*;

public class BJ2748 {
  private static long solution(int n) {
    long[] arr = new long[n + 1];
    arr[0] = 0;
    arr[1] = 1;

    for (int i = 2; i <= n; ++i) {
      arr[i] = arr[i - 2] + arr[ i - 1];
    }

    return arr[n];
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long answer = solution(n);
    System.out.println(answer);
  }
}
