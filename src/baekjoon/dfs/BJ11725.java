package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class BJ11725 {
  static ArrayList<ArrayList<Integer>> graph;
  static int[] answer;

  private static void solution(int vertex) {
    for (int x : graph.get(vertex)) {
      if (answer[x] != 0) continue;
      answer[x] = vertex;
      solution(x);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    graph = new ArrayList<>(n + 1);
    for (int i = 0; i <= n; ++i) {
      graph.add(new ArrayList<>());
    }
    answer = new int[n + 1];

    for (int i = 0; i < n - 1; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int vertex1 = Integer.parseInt(st.nextToken());
      int vertex2 = Integer.parseInt(st.nextToken());
      graph.get(vertex1).add(vertex2);
      graph.get(vertex2).add(vertex1);
    }
    solution(1);
    for (int i = 2; i <= n; ++i) {
      System.out.println(answer[i]);
    }
  }
}
