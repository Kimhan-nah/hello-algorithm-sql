package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class BJ11866 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < n; ++i) {
      list.add(i);
    }

    // solution
    int index = 0;
    ArrayList<Integer> answer = new ArrayList<>();
    while (!list.isEmpty()) {
      index = (index + k - 1) % list.size();
      int remove = list.remove(index);
      answer.add(remove + 1);
    }
    StringBuilder sb = new StringBuilder();
    sb.append("<");
    for (int i = 0; i < answer.size(); ++i) {
      sb.append(answer.get(i));
      if (i != answer.size() - 1) sb.append(", ");
    }
    sb.append(">");
    System.out.println(sb);

  }
}
