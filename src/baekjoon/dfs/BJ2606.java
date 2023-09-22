package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class BJ2606 {
  private static boolean[] visited;
  private static void solution(int[][] arr, int vertex) {
    visited[vertex] = true;
    for (int[] x : arr) {
      if (x[0] == vertex && !visited[x[1]]) {
        solution(arr, x[1]);
      } else if (x[1] == vertex && !visited[x[0]]) {
        solution(arr, x[0]);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int connected = Integer.parseInt(br.readLine());
    int[][] arr = new int[connected + 1][2];
    visited = new boolean[n + 1];

    for (int i = 1; i <= connected; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }
    solution(arr, 1);
    int answer = 0;
    for (boolean x : visited) {
      if (x) ++answer;
    }
    System.out.println(answer - 1);
  }
}
