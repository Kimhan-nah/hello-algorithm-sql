package baekjoon.dynamic_programming;

import java.io.*;
import java.util.*;

public class BJ11053 {
  static int[] arr;
  static Integer[] check;
  private static int solution(int idx, int max) {
    if (idx == arr.length) return 0;
//    if (check[idx] != 0) return check[idx];

    int count = 0;
    if (arr[idx] > max) {
      count = 1 + solution(idx + 1, arr[idx]);
    }
    check[idx] = Math.max(count, solution(idx + 1, max));
    return check[idx];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    arr = new int[n];
    check = new Integer[n];
    Arrays.fill(check, 0);
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    solution(0, Integer.MIN_VALUE);
    Arrays.sort(check, Collections.reverseOrder());
    System.out.println(check[0]);
  }
}
