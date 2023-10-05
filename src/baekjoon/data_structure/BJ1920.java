package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class BJ1920 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; ++i) {
      set.add(Integer.parseInt(st.nextToken()));
    }
    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; ++i) {
      int x = Integer.parseInt(st.nextToken());
      if (set.contains(x)) {
        sb.append("1\n");
      } else {
        sb.append("0\n");
      }
    }
    System.out.println(sb);
  }
}
