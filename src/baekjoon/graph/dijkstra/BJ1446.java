package baekjoon.graph.dijkstra;

import java.io.*;
import java.util.*;

public class BJ1446 {
  static HashMap<Integer, List<Edge>> graph;
  static HashMap<Integer, Integer> dis;
  static int N, D;
  static class Edge {
    int  end, cost;

    public Edge(int end, int cost) {
      this.end = end;
      this.cost = cost;
    }
  }

  private static int solution(List<Integer> keySet) {
    Queue<Edge> pq = new PriorityQueue<>((a, b) -> {
      return a.cost - b.cost;
    });
    int before = 0;

    for (int key : keySet) {
      if (key == 0) continue;
      graph.get(before).add(new Edge(key, key - before));
      graph.get(key).add(new Edge(D, D - key));
      before = key;
    }

    pq.offer(new Edge(0, 0));
    dis.put(0, 0);

    while (!pq.isEmpty()) {
      Edge now = pq.poll();
      if (now.cost > dis.get(now.end)) continue;
      if (now.end == D) break ;
      for (Edge next : graph.get(now.end)) {
        if (dis.get(next.end) > now.cost + next.cost) {
          dis.put(next.end, now.cost + next.cost);
          pq.offer(new Edge(next.end, now.cost + next.cost));
        }
      }
    }
    return Math.min(D, dis.get(D));
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());
    graph = new HashMap<>();
    dis = new HashMap<>();

    graph.put(0, new ArrayList<>());
    graph.get(0).add(new Edge(D, D));
    dis.put(0, Integer.MAX_VALUE);
    dis.put(D, Integer.MAX_VALUE);

    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      if (start >= D || end > D) continue;
      if (!graph.containsKey(start)) {
        graph.put(start, new ArrayList<>());
      }
      if (!graph.containsKey(end)) {
        graph.put(end, new ArrayList<>());
      }
      graph.get(start).add(new Edge(end, cost));
      dis.put(start, Integer.MAX_VALUE);
      dis.put(end, Integer.MAX_VALUE);
    }

    List<Integer> keySet = new ArrayList<Integer>(graph.keySet());
    Collections.sort(keySet);

    int answer = solution(keySet);
    System.out.println(answer);
  }
}
