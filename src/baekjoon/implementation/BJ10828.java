package baekjoon.implementation;

import java.util.*;
import java.io.*;

public class BJ10828 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();
    String[] arr = new String[n];
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String cmd = st.nextToken();
      switch (cmd) {
        case "push":
          stack.push(Integer.parseInt(st.nextToken()));
          break;
        case "pop":
          if (stack.isEmpty()) {
            sb.append(-1 + "\n");
          } else {
            int pop = stack.pop();
            sb.append(pop + "\n");
          }
          break;
        case "size":
          sb.append(stack.size() + "\n");
          break;
        case "empty":
          sb.append((stack.isEmpty() ? 1 : 0) + "\n");
          break;
        case "top":
          if (stack.isEmpty()) {
            sb.append(-1 + "\n");
          } else {
            sb.append(stack.peek() + "\n");
          }
          break;
      }
    }
    System.out.println(sb);
  }
}
