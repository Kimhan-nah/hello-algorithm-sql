package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class BJ11047 {
  private static int solution(Integer[] arr, int k) {
    Arrays.sort(arr, Collections.reverseOrder());
    int count = 0;

    for (Integer x : arr) {
      if (x <= k) {
        count = count + (k / x);
        k %= x;
      }
      if (k == 0) break ;
    }

    return count;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    Integer[] arr = new Integer[n];

    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    int answer = solution(arr, k);
    System.out.println(answer);
  }
}
