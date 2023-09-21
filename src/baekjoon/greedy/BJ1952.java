package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class BJ1952 {
  private static int solution(int n, int k) {
    if (n <= k) return 0;

    int answer = n;
    while (true) {
      int x = answer;
      int count = 0;
      while (x > 0) {
        if ((x&1) == 1) {
          ++count;
        }
        x /= 2;
      }

      if (count <= k) break;
      ++answer;
    }

    return answer - n;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int answer = solution(n, k);
    System.out.println(answer);

    // 13 3

  }
}
