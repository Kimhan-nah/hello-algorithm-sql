package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class BJ15903 {
  private static long solution(PriorityQueue<Long> cards, int m) {
    long answer = 0;

    for (int i = 0; i < m; ++i) {
      long tmp = cards.poll() + cards.poll();
      cards.offer(tmp);
      cards.offer(tmp);
    }
    while (!cards.isEmpty()) {
      answer += cards.poll();
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    PriorityQueue<Long> cards = new PriorityQueue<>(n);

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      cards.offer(Long.parseLong(st.nextToken()));
    }
    long answer = solution(cards, m);
    System.out.println(answer);
  }
}
