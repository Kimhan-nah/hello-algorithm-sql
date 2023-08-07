package inflearn.section_8;

import java.util.*;
import java.io.*;

public class Riding {
  static int maxKg;
  private static int DFS(int[] arr, int level, int sum) {
    if (level == arr.length)
      return sum > maxKg ? -1 : sum;
    return Math.max(DFS(arr, level + 1, sum + arr[level]), DFS(arr, level + 1, sum));
  }

  private static void solution(int[] arr) {
    int answer = DFS(arr, 0, 0);
    System.out.println(answer);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    maxKg = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    solution(arr);
  }
}
