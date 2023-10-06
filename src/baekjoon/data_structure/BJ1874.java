package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class BJ1874 {
  private static void solution(int[] arr, int n) {
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int index = 0;

    for (int i = 1; i <= n; ++i) {
      while (!stack.isEmpty() && stack.peek() == arr[index]) {
        ++index;
        stack.pop();
        sb.append("-\n");
      }
      stack.push(i);
      sb.append("+\n");
    }
    while (!stack.isEmpty() && stack.peek() == arr[index]) {
      ++index;
      stack.pop();
      sb.append("-\n");
    }
    if (!stack.isEmpty()) {
      sb.setLength(0);
      sb.append("NO\n");
    }
    System.out.println(sb);
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    solution(arr, n);
  }
}
