package inflearn.section_8;

import java.io.*;
import java.util.*;

public class CoinExchange {
  private static int m, answer = Integer.MAX_VALUE;
  private static Integer[] arr;
  private static void solution(int level, int current) {
    if (current > m) return ;
    if (level > answer) return ;
    if (current == m) {
      answer = Math.min(answer, level);
      return ;
    }

    for (int i = 0; i < arr.length; ++i) {
      solution(level + 1, current + arr[i]);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    arr = new Integer[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr, Collections.reverseOrder());
    m = Integer.parseInt(br.readLine());
    solution(0, 0);
    System.out.println(answer);
  }
}
