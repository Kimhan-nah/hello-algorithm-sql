package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class BJ15903 {
  private static long solution(long[] cards, int m) {
    for (int i = 0; i < m; ++i) {
      Arrays.sort(cards);
      long tmp = cards[0] + cards[1];
      cards[0] = tmp;
      cards[1] = tmp;
    }
    return  Arrays.stream(cards).sum();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    long[] cards = new long[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      cards[i] = Integer.parseInt(st.nextToken());
    }
    long answer = solution(cards, m);
    System.out.println(answer);
  }
}
