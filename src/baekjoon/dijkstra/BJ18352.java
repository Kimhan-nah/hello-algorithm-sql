package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class BJ18352 {
  static StringBuilder sb = new StringBuilder();
  static ArrayList<Integer>[] graph;
  static int n, m, x, k;

  static class Edge {
    int vertex, dis;

    public Edge(int vertex, int dis) {
      this.vertex = vertex;
      this.dis = dis;
    }
  }
  private static void solution() {
    Queue<Edge> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
    int[] dis = new int[n + 1];
    boolean[] visited = new boolean[n + 1];

    Arrays.fill(dis, Integer.MAX_VALUE);
    pq.offer(new Edge(x, 0));
    dis[x] = 0;
    visited[x] = true;

    while (!pq.isEmpty()) {
      Edge current = pq.poll();
      for (int next : graph[current.vertex]) {
        if (visited[next] || current.dis + 1 > dis[next]) continue;
        dis[next] = current.dis + 1;
        visited[next] = true;
        pq.offer(new Edge(next, current.dis + 1));
      }
    }

    int count = 0;
    for (int i = 1; i < dis.length; ++i) {
      if (dis[i] == k) {
        sb.append(i);
        sb.append("\n");
        ++count;
      }
    }
    if (count == 0) sb.append(-1);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    graph = new ArrayList[n + 1];

    // init graph
    for (int i = 0; i <= n; ++i) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      graph[v1].add(v2);
    }
    solution();
    System.out.println(sb);
  }
}
