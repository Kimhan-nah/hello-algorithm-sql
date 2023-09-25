package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class BJ11724 {
  static int n, m;
  static ArrayList<Integer>[] graph;
  static boolean[] check;

  private static void DFS(int row) {
    check[row] = true;

    for (int x : graph[row]) {
      if (!check[x])
        DFS(x);
    }
  }

  private static int solution() {
    int answer = 0;

    for (int i = 1; i < graph.length; ++i) {
      if (check[i]) continue;
      check[i] = true;
      if (graph[i].isEmpty()) {
        ++answer;
        continue;
      }
      for (int x : graph[i]) {
        if (check[x]) continue;
        DFS(x);
      }
      ++answer;
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());   // vertex
    m = Integer.parseInt(st.nextToken());   // edge
    graph = new ArrayList[n + 1];
    check = new boolean[n + 1];

    // init
    for (int i = 0; i <= n; ++i) {
      graph[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int vertex1 = Integer.parseInt(st.nextToken());
      int vertex2 = Integer.parseInt(st.nextToken());
      graph[vertex1].add(vertex2);
      graph[vertex2].add(vertex1);
    }

    int answer = solution();
    System.out.println(answer);
  }
}
