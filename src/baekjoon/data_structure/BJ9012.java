package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class BJ9012 {
  private static void solution(String[] arr) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < arr.length; ++i) {
      int count = 0;
      char[] tmp = arr[i].toCharArray();
      Stack<Character> stack = new Stack<>();
      for (int j = 0; j < tmp.length; ++j) {
        if (tmp[j] == '(') {
          stack.push('(');
        } else {
          if (stack.isEmpty()) {
            stack.push(')');
            break ;
          }
          stack.pop();
        }
      }
      if (stack.isEmpty()) {
        sb.append("YES\n");
      } else {
        sb.append("NO\n");
      }
    }
    System.out.println(sb);

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    String[] arr = new String[T];
    for (int i = 0; i < T; ++i) {
      arr[i] = br.readLine();
    }
    solution(arr);
  }
}
