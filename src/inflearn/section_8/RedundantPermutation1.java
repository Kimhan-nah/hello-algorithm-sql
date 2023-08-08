package inflearn.section_8;

import java.io.*;
import java.util.*;

public class RedundantPermutation1 {
  private static int n, m;
  private static int[] arr;

  private static void solution(int level) {
    if (level > m) {
      System.out.println(Arrays.toString(arr));
      return ;
    }
    for (int  i = 1; i <= n; ++i) {
      arr[level] = i;
      solution(level + 1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[m + 1];

    solution(1);
  }
}
