package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class BJ1026 {
  private static int solution(Integer[] a, Integer[] b) {
    int answer = 0;
    // a는 오름차순, b는 내림차순 정렬
    Arrays.sort(a);
    Arrays.sort(b, Collections.reverseOrder());

    for (int i = 0; i < a.length; ++i) {
      answer += (a[i] * b[i]);
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] a = new Integer[n];
    Integer[] b = new Integer[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      b[i] = Integer.parseInt(st.nextToken());
    }
    int answer = solution(a, b);
    System.out.println(answer);
  }
}
