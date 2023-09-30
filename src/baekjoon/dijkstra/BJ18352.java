package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class BJ18352 {
  static StringBuilder sb = new StringBuilder();
  static ArrayList<Integer>[] graph;
  static int[] dis;

  static class Edge implements Comparable<Edge> {
    int vertex, dis;

    public Edge(int vertex, int dis) {
      this.vertex = vertex;
      this.dis = dis;
    }

    @Override
    public int compareTo(Edge o) {
      return dis - o.dis;
    }
  }
  private static void solution(int x, int k) {
    Queue<Edge> pq = new PriorityQueue<>();

    pq.offer(new Edge(x, 0));
    dis[x] = 0;

    while (!pq.isEmpty()) {
      Edge current = pq.poll();
      for (int next : graph[current.vertex]) {
        if (current.dis + 1 > dis[next]) continue;
        dis[next] = current.dis + 1;
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
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    graph = new ArrayList[n + 1];
    dis = new int[n + 1];

    // init graph
    for (int i = 0; i <= n; ++i) {
      graph[i] = new ArrayList<>();
    }

    Arrays.fill(dis, Integer.MAX_VALUE);
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      graph[v1].add(v2);
    }
    solution(x, k);
    System.out.println(sb);
  }
}
