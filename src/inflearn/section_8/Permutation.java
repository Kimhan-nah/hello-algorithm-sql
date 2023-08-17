package inflearn.section_8;

import java.util.*;
import java.io.*;

public class Permutation {
  static int n, m;
  static int[] arr, check;

  private static void solution(int level, int[] buf) {
    if (level == m) {
      System.out.println(Arrays.toString(buf));
      return ;
    }
    for (int i = 0; i < arr.length; ++i) {
      if (check[i] != 1) {
        check[i] = 1;
        buf[level] = arr[i];
        solution(level + 1, buf);
        check[i] = 0;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[n];
    check = new int[n];
    int[] buf = new int[m];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    solution(0, buf);
  }
}
