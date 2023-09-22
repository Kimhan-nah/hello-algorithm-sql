package inflearn.section_9;

import java.util.*;

class Edge implements Comparable<Edge> {
  public int vex, cost;

  public Edge(int vex, int cost) {
    this.vex = vex;
    this.cost = cost;
  }

  @Override
  public int compareTo(Edge o) {
    return cost - o.cost;
  }
}

public class Dijkstra {
  static int n, m;
  static ArrayList<ArrayList<Edge>> graph;
  static int[] dis;
  private static void solution(int v) {
    PriorityQueue<Edge> pq = new PriorityQueue<>();

    pq.offer(new Edge(v, 0));
    dis[v] = 0;

    while (!pq.isEmpty()) {
      Edge now = pq.poll();
      if (now.cost > dis[now.vex]) continue;
      for (Edge edge : graph.get(now.vex)) {
        if (dis[edge.vex] > now.cost + edge.cost) {
          dis[edge.vex] = now.cost + edge.cost;
          pq.offer(new Edge(edge.vex, now.cost + edge.cost));
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    graph = new ArrayList<ArrayList<Edge>>();
    dis = new int[n + 1];

    // init graph
    for (int i = 0; i <= n; ++i) {
      graph.add(new ArrayList<>());
    }
    // init dis
    Arrays.fill(dis, Integer.MAX_VALUE);

    for (int i = 0; i < m; ++i) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      graph.get(a).add(new Edge(b, c));
    }

    solution(1);

    // print
    for (int i = 2; i <= n; ++i) {
      if (dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
      else System.out.println(i + " : impossible");
    }
  }
}
