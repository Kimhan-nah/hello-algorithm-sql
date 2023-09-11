package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class BJ1260 {
  private static int[] check;
  private static StringBuilder sb = new StringBuilder();

  private static boolean isFinished() {
    for (int i = 1; i < check.length; ++i) {
      if (check[i] != 1)
        return false;
    }
    return true;
  }
  private static void DFS(int[][] graph, int vertex) {
    if (isFinished()) return;
    check[vertex] = 1;
//    System.out.print(vertex + " ");
    sb.append(vertex).append(" ");

    for (int i = 0; i < graph.length; ++i) {
      if (check[i] != 1 && graph[vertex][i] == 1)  {
        DFS(graph, i);
      }
    }
  }

  private static void BFS(int[][] graph, int vertex) {
    Queue<Integer> queue = new LinkedList<>();

    queue.offer(vertex);
    check[vertex] = 1;

    while (!queue.isEmpty()) {
      int pop = queue.poll();
//      System.out.print(pop + " ");
      sb.append(pop).append(" ");
      for (int i = 0; i < graph.length; ++i) {
        if (check[i] != 1 && graph[pop][i] == 1) {
          queue.offer(i);
          check[i] = 1;
        }
      }
    }
  }

  private static void solution(int[][] graph, int vertex) {
    DFS(graph, vertex);
//    System.out.println();
    sb.append("\n");
    Arrays.fill(check, 0);
    BFS(graph, vertex);
    System.out.println(sb);

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int start = Integer.parseInt(st.nextToken());

    check = new int[n + 1];
    int[][] graph = new int[n + 1][n + 1];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int vertex1 = Integer.parseInt(st.nextToken());
      int vertex2 = Integer.parseInt(st.nextToken());
      graph[vertex1][vertex2] = 1;
      graph[vertex2][vertex1] = 1;
    }
    solution(graph, start);
  }
}
