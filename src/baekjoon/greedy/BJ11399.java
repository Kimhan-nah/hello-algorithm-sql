package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class BJ11399 {
  private static int solution(int[] arr, int n) {
    Arrays.sort(arr);
    int answer = arr[0];
    for (int i = 1; i < n; ++i ) {
      arr[i] = arr[i - 1] + arr[i];
      answer += arr[i];
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i)
      arr[i] = Integer.parseInt(st.nextToken());
    int answer = solution(arr, n);
    System.out.println(answer);
  }
}
